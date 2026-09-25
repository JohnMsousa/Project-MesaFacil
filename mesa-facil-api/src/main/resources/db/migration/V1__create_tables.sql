CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash TEXT NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'waiter'
        CHECK (role IN ('waiter', 'cashier', 'manager', 'admin')),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE tables (
    id BIGSERIAL PRIMARY KEY,
    number INT NOT NULL UNIQUE,
    capacity INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE menu_items (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE shifts (
    id BIGSERIAL PRIMARY KEY,

    opened_by BIGINT NOT NULL,
    closed_by BIGINT,

    status VARCHAR(20) NOT NULL DEFAULT 'open'
        CHECK (status IN ('open', 'closed')),

    opened_at TIMESTAMP NOT NULL,
    closed_at TIMESTAMP,

    CONSTRAINT fk_shifts_opened_by
        FOREIGN KEY (opened_by)
        REFERENCES users(id),

    CONSTRAINT fk_shifts_closed_by
        FOREIGN KEY (closed_by)
        REFERENCES users(id)
);

CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,

    table_id BIGINT NOT NULL,
    shift_id BIGINT NOT NULL,
    opened_by BIGINT NOT NULL,

    status VARCHAR(30) NOT NULL DEFAULT 'open'
        CHECK (
            status IN (
                'open',
                'in_kitchen',
                'ready_to_pay',
                'closed',
                'canceled'
            )
        ),

    service_charge_applied BOOLEAN NOT NULL DEFAULT FALSE,
    service_charge_rate DECIMAL(5,2) NOT NULL DEFAULT 10.00,

    opened_at TIMESTAMP NOT NULL,
    closed_at TIMESTAMP,

    canceled_at TIMESTAMP,
    canceled_by BIGINT,
    cancellation_reason TEXT,

    CONSTRAINT fk_orders_table
        FOREIGN KEY (table_id)
        REFERENCES tables(id),

    CONSTRAINT fk_orders_shift
        FOREIGN KEY (shift_id)
        REFERENCES shifts(id),

    CONSTRAINT fk_orders_opened_by
        FOREIGN KEY (opened_by)
        REFERENCES users(id),

    CONSTRAINT fk_orders_canceled_by
        FOREIGN KEY (canceled_by)
        REFERENCES users(id)
);

CREATE TABLE order_items (
    id BIGSERIAL PRIMARY KEY,

    order_id BIGINT NOT NULL,
    menu_item_id BIGINT NOT NULL,

    quantity INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    observation TEXT,

    status VARCHAR(20) NOT NULL DEFAULT 'pending'
        CHECK (
            status IN (
                'pending',
                'sent',
                'preparing',
                'ready',
                'canceled'
            )
        ),

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    canceled_at TIMESTAMP,
    canceled_by BIGINT,
    cancellation_reason TEXT,

    CONSTRAINT fk_order_items_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id),

    CONSTRAINT fk_order_items_menu_item
        FOREIGN KEY (menu_item_id)
        REFERENCES menu_items(id),

    CONSTRAINT fk_order_items_canceled_by
        FOREIGN KEY (canceled_by)
        REFERENCES users(id)
);

CREATE TABLE payments (
    id BIGSERIAL PRIMARY KEY,

    order_id BIGINT NOT NULL,
    received_by BIGINT NOT NULL,

    amount DECIMAL(10,2) NOT NULL,

    payment_method VARCHAR(30) NOT NULL
        CHECK (
            payment_method IN (
                'cash',
                'credit_card',
                'debit_card',
                'pix'
            )
        ),

    paid_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_payments_order
        FOREIGN KEY (order_id)
        REFERENCES orders(id),

    CONSTRAINT fk_payments_received_by
        FOREIGN KEY (received_by)
        REFERENCES users(id)
);

CREATE TABLE audit_logs (
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    entity_type VARCHAR(50) NOT NULL,
    entity_id BIGINT NOT NULL,

    action VARCHAR(50) NOT NULL,
    reason TEXT,

    metadata JSON,

    created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_audit_logs_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);
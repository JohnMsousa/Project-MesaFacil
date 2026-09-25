package com.example.mesa_facil_api.model.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Getter
public enum RoleEnum {

    WAITER("waiter", "ROLE_WAITER", "Garcom"),
    CASHIER("cashier", "ROLE_CASHIER", "Caixa"),
    MANAGER("manager", "ROLE_MANAGER", "Gerente"),
    ADMIN("admin", "ROLE_ADMIN", "Administrador");

    private final String valor;
    private final String role;
    private final String description;

    RoleEnum(String valor, String role, String description) {
        this.valor = valor;
        this.role = role;
        this.description = description;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role));
    }
}
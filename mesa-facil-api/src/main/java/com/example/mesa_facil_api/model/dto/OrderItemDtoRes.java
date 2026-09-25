package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderItemDtoRes(
        Long id,
        Long orderId,
        Long menuItemId,
        Integer quantity,
        BigDecimal unitPrice,
        String observation,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime canceledAt,
        Long canceledById,
        String cancellationReason
) {
}
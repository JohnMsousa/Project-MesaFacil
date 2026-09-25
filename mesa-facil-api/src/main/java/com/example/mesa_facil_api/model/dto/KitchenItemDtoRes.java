package com.example.mesa_facil_api.model.dto;

import java.time.LocalDateTime;

public record KitchenItemDtoRes(
        Long id,
        Long orderId,
        Long menuItemId,
        String menuItemName,
        Integer quantity,
        String observation,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
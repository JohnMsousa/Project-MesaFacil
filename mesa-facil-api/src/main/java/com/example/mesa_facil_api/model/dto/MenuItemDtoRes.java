package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MenuItemDtoRes(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Boolean available,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
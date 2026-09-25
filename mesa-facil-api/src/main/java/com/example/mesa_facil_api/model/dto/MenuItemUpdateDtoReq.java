package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;

public record MenuItemUpdateDtoReq(
        String name,
        String description,
        BigDecimal price,
        Boolean available
) {
}
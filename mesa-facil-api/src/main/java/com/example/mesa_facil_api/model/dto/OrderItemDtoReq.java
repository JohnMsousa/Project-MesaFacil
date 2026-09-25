package com.example.mesa_facil_api.model.dto;

public record OrderItemDtoReq(
        Long menuItemId,
        Integer quantity,
        String observation
) {
}
package com.example.mesa_facil_api.model.dto;

public record OrderItemUpdateDtoReq(
        Integer quantity,
        String observation
) {
}
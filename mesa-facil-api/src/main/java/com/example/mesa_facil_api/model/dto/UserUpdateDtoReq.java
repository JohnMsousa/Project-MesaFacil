package com.example.mesa_facil_api.model.dto;

public record UserUpdateDtoReq(
        String name,
        String email,
        String password,
        String role
) {
}
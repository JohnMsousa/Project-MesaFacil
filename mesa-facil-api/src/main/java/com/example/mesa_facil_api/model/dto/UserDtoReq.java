package com.example.mesa_facil_api.model.dto;

import com.example.mesa_facil_api.model.enums.RoleEnum;

public record UserDtoReq(
        String name,
        String email,
        String password,
        RoleEnum role
) {
}
package com.example.mesa_facil_api.model.dto;

public record LoginDtoRes(
        String token,
        UserDtoRes user
) {
}
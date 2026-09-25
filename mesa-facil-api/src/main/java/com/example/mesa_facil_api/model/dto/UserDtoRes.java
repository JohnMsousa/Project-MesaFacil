package com.example.mesa_facil_api.model.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserDtoRes(
        Long id,
        String name,
        String email,
        String role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
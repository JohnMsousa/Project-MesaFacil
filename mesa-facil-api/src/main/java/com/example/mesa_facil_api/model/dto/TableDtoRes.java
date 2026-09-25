package com.example.mesa_facil_api.model.dto;

import java.time.LocalDateTime;

public record TableDtoRes(
        Long id,
        Integer number,
        Integer capacity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
package com.example.mesa_facil_api.model.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record TableDtoRes(
        Long id,
        Integer number,
        Integer capacity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
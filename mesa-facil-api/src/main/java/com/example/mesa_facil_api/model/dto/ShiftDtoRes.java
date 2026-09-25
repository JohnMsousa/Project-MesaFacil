package com.example.mesa_facil_api.model.dto;

import java.time.LocalDateTime;

public record ShiftDtoRes(
        Long id,
        Long openedById,
        Long closedById,
        String status,
        LocalDateTime openedAt,
        LocalDateTime closedAt
) {
}
package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderDtoRes(
        Long id,
        Long tableId,
        Long shiftId,
        Long openedById,
        String status,
        Boolean serviceChargeApplied,
        BigDecimal serviceChargeRate,
        LocalDateTime openedAt,
        LocalDateTime closedAt,
        LocalDateTime canceledAt,
        Long canceledById,
        String cancellationReason
) {
}
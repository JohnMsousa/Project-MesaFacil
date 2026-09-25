package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TableOrderDtoRes(
        Long id,
        Long tableId,
        String status,
        Boolean serviceChargeApplied,
        BigDecimal serviceChargeRate,
        LocalDateTime openedAt,
        LocalDateTime closedAt
) {
}
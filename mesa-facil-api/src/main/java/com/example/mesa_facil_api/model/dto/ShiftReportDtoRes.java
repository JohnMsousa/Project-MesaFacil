package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;

public record ShiftReportDtoRes(
        Long shiftId,
        String status,
        Long totalOrders,
        BigDecimal totalSales,
        BigDecimal totalPayments
) {
}
package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;

public record OrderDtoReq(
        Long tableId,
        Long shiftId,
        Boolean serviceChargeApplied,
        BigDecimal serviceChargeRate
) {
}
package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;

public record OrderServiceFeeDtoReq(
        Boolean serviceChargeApplied,
        BigDecimal serviceChargeRate
) {
}
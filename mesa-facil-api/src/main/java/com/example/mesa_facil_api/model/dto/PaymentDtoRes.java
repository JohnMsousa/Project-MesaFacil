package com.example.mesa_facil_api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentDtoRes(
        Long id,
        Long orderId,
        Long receivedById,
        BigDecimal amount,
        String paymentMethod,
        LocalDateTime paidAt
) {
}
package com.sparking.orderservice.api.service.dto;

public record PaymentDto(
        Long paymentId,
        String paymentStatus,
        String transactionId,
        Long orderId,
        double amount) { }

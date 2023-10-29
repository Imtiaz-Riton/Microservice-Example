package com.sparking.paymentservice.api.service.dto;

public record OrderDto(
        Long id,
        String name,
        int qty,
        double price
)  { }

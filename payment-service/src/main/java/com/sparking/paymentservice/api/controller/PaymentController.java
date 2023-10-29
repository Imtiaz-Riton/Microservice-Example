package com.sparking.paymentservice.api.controller;

import com.sparking.paymentservice.api.domain.Payment;
import com.sparking.paymentservice.api.service.PaymentService;
import com.sparking.paymentservice.api.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService service;

    @PostMapping
    public Payment doPayment(@RequestBody OrderDto order) {
        return service.savePayment(order);
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return service.getPaymentById(id);
    }
}

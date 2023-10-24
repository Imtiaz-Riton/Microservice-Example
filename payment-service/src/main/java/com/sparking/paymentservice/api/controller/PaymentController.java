package com.sparking.paymentservice.api.controller;

import com.sparking.paymentservice.api.domain.Payment;
import com.sparking.paymentservice.api.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService service;

    @PostMapping
    public Payment doPayment(@RequestBody Payment payment){
        return service.savePayment(payment);
    }
}

package com.sparking.paymentservice.api.service;

import com.sparking.paymentservice.api.domain.Payment;
import com.sparking.paymentservice.api.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository repo;

    public Payment savePayment(Payment payment){
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());
        payment.setOrderId(new Random().nextLong());
        payment.setAmount(new Random().nextDouble());
        return repo.save(payment);
    }

    private String paymentProcessing(){
        return new Random().nextBoolean() ? "success" : "failed";
    }
}

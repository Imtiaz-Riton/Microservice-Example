package com.sparking.paymentservice.api.service;

import com.sparking.paymentservice.api.domain.Payment;
import com.sparking.paymentservice.api.repository.PaymentRepository;
import com.sparking.paymentservice.api.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository repo;

    public Payment savePayment(OrderDto order){
        Payment payment = new Payment();
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());
        payment.setOrderId(order.id());
        payment.setAmount(order.price());
        return repo.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return repo.findByOrderId(id)
                .orElseThrow(() -> new RuntimeException("order does not exist by this id"));
    }

    private String paymentProcessing(){
        return new Random().nextBoolean() ? "success" : "failed";
    }
}

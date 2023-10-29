package com.sparking.orderservice.api.service;

import com.sparking.orderservice.api.client.PaymentServiceClient;
import com.sparking.orderservice.api.domain.Order;
import com.sparking.orderservice.api.repository.OrderRepository;
import com.sparking.orderservice.api.service.dto.PaymentDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository repo;
    private final PaymentServiceClient client;

    public Order saveOrder(Order order){
        log.info("Order: {}", order);
        return repo.save(order);
    }

    public Order getOrderById(Long id) {
        return repo.findById(id).get();
    }

    public PaymentDto getPaymentById(Long id){
        return client.getPaymentById(id);
    }

    public PaymentDto makePayment(Order order){
        return client.makePayment(order);
    }
}

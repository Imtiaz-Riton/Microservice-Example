package com.sparking.orderservice.api.controller;

import com.sparking.orderservice.api.domain.Order;
import com.sparking.orderservice.api.service.OrderService;
import com.sparking.orderservice.api.service.dto.PaymentDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;
    private static final String SERVICE_NAME = "orderService";

    @PostMapping("/bookOrder")
    public Order bookOrder(@RequestBody Order order){
        return service.saveOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        return service.getOrderById(id);
    }

    @GetMapping("/payment/{id}")
    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "getAvailablePayment")
    public PaymentDto getPaymentById(@PathVariable Long id){
        return service.getPaymentById(id);
    }

    @PostMapping("/make-payment")
    public PaymentDto makePayment(@RequestBody Order order){
        return service.makePayment(order);
    }

    public PaymentDto getAvailablePayment(Exception e){
        return new PaymentDto(1L, "customized", "1", 1L, 4.6);
    }
}

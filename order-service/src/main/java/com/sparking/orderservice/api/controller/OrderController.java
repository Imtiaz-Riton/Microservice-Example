package com.sparking.orderservice.api.controller;

import com.sparking.orderservice.api.domain.Order;
import com.sparking.orderservice.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order")
public class OrderController {
    private final OrderService service;

    @PostMapping("/bookOrder")
    public Order bookOrder(@RequestBody Order order){
        return service.saveOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        return service.getOrderById(id);
    }
}

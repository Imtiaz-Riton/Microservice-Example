package com.sparking.orderservice.api.service;

import com.sparking.orderservice.api.domain.Order;
import com.sparking.orderservice.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository repo;

    public Order saveOrder(Order order){
        log.info("Order: {}", order);
        return repo.save(order);
    }

    public Order getOrderById(Long id) {
        return repo.findById(id).get();
    }
}

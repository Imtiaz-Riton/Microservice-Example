package com.sparking.orderservice.api.client;

import com.sparking.orderservice.api.domain.Order;
import com.sparking.orderservice.api.service.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("payment-service")
public interface PaymentServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/payment/{id}", consumes = "application/json")
    PaymentDto getPaymentById(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/payment", consumes = "application/json")
    PaymentDto makePayment(@RequestBody Order order);
}

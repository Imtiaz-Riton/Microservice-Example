package com.sparking.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    
    @GetMapping("/orderFallback")
    public String orderServiceFallback(){
        return "order service is taking too long";
    }

    @GetMapping("/paymentFallback")
    public String paymentServiceFallback(){
        return "payment service is taking too long";
    }
}

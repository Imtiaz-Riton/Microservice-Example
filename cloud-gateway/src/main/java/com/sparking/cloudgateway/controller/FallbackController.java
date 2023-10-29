package com.sparking.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    
    @RequestMapping("/orderFallback")
    public String orderServiceFallback(){
        return "order service is taking too long, comeback later";
    }

    @RequestMapping("/paymentFallback")
    public String paymentServiceFallback(){
        return "payment service is taking too long, comeback later";
    }
}

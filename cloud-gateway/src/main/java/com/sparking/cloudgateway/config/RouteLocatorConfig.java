package com.sparking.cloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r
                        .path("/order/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("my-cmd")
                                .setFallbackUri("forward:/orderFallback")))
                        .uri("lb://ORDER-SERVICE"))
                .route(r -> r
                        .path("/payment/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("my-cmd")
                                .setFallbackUri("forward:/paymentFallback")))
                        .uri("lb://PAYMENT-SERVICE"))
                .build();
    }
}

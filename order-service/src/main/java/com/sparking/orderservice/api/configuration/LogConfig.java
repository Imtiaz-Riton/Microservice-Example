package com.sparking.orderservice.api.configuration;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LogConfig {
    @Bean
    public static Logger getLog() {
        return log;
    }
}

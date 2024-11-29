package com.example.consumer;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class NameSourceConfiguration {

    @Bean
    public Supplier<String> supplyName() {
        return () -> "Christopher Pike";
    }
}


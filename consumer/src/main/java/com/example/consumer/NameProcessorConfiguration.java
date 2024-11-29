package com.example.consumer;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.Date;

@Component
public class NameProcessorConfiguration {

    @Bean
    public Function<String, Person> processName() {
        return name -> new Person(name, new Date().getTime());
    }
}


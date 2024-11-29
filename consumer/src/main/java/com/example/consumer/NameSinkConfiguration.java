package com.example.consumer;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class NameSinkConfiguration {

    @Bean
    public Consumer<Person> nameSink() {
        return person -> {
            System.out.println("Name: " + person.name());
            System.out.println("Processed Timestamp: " + person.processedTimestamp());
        };
    }
}


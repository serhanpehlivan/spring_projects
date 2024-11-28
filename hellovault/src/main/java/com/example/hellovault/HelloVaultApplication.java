package com.example.hellovault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MyConfiguration.class)
public class HelloVaultApplication implements CommandLineRunner {

    private final MyConfiguration configuration;

    public HelloVaultApplication(MyConfiguration configuration) {
        this.configuration = configuration;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloVaultApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Logger logger = LoggerFactory.getLogger(HelloVaultApplication.class);

        logger.info("----------------------------------------");
        logger.info("Configuration properties");
        logger.info("   example.username is {}", configuration.getUsername());
        logger.info("   example.password is {}", configuration.getPassword());
        logger.info("----------------------------------------");
    }
}

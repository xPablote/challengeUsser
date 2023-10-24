package com.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiRestApplication {

    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(ApiRestApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ApiRestApplication.class, args);
    }
}

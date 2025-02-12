package com.example.demo_sb_customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo_sb_customer", "com.example.dto.mapper"})

public class DemoSbCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoSbCustomerApplication.class, args);
    }
}


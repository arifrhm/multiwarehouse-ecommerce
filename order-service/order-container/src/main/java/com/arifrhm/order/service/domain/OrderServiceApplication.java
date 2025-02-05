package com.arifrhm.order.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.arifrhm.order.service.dataaccess", "com.arifrhm.dataaccess" })
@EntityScan(basePackages = { "com.arifrhm.order.service.dataaccess", "com.arifrhm.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.arifrhm")
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
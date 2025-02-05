package com.arifrhm.product.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.arifrhm.product.service.dataaccess", "com.arifrhm.dataaccess" })
@EntityScan(basePackages = { "com.arifrhm.product.service.dataaccess", "com.arifrhm.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.arifrhm")
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
package com.arifrhm.warehouse.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.arifrhm.warehouse.service.dataaccess", "com.arifrhm.dataaccess" })
@EntityScan(basePackages = { "com.arifrhm.warehouse.service.dataaccess", "com.arifrhm.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.arifrhm")
public class WarehouseServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(WarehouseServiceApplication.class, args);
    }
}
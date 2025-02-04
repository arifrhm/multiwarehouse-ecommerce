package com.arifrhm.user.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.arifrhm.user.service.dataaccess", "com.arifrhm.dataaccess" })
@EntityScan(basePackages = { "com.arifrhm.user.service.dataaccess", "com.arifrhm.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.arifrhm")
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
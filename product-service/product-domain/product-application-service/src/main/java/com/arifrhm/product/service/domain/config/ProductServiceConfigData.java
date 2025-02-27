package com.arifrhm.product.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "product-service")
public class ProductServiceConfigData {
    private String productCreatedTopicName;
    private String stockCreatedTopicName;
    private String stockUpdatedTopicName;
}

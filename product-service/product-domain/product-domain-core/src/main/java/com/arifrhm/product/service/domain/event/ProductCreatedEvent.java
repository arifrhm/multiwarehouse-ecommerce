package com.arifrhm.product.service.domain.event;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.product.service.domain.entity.Product;

import java.time.ZonedDateTime;

public class ProductCreatedEvent extends ProductEvent {

    private final DomainEventPublisher<ProductCreatedEvent> productCreatedEventPublisher;

    public ProductCreatedEvent(Product product, ZonedDateTime createdAt, DomainEventPublisher<ProductCreatedEvent> productCreatedEventPublisher) {
        super(product, createdAt);
        this.productCreatedEventPublisher = productCreatedEventPublisher;
    }

    @Override
    public void fire() {
        productCreatedEventPublisher.publish(this);
    }
}

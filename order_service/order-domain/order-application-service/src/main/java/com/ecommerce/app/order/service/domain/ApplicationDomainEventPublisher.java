package com.ecommerce.app.order.service.domain;

import com.ecommerce.common.domain.event.publisher.DomainEventPublisher;
import com.ecommerce.app.order.service.domain.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ApplicationDomainEventPublisher implements DomainEventPublisher<OrderCreatedEvent> {

    private final ApplicationEventPublisher applicationEventPublisher;

    public ApplicationDomainEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(OrderCreatedEvent domainEvent) {
        this.applicationEventPublisher.publishEvent(domainEvent);
        log.info("OrderCreatedEvent is published for order id: {}", domainEvent.getOrder().getId().getValue());
    }
}

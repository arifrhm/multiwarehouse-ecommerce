package multiwarehouse.payment_service;

import java.util.logging.Logger;

import multiwarehouse.common.domain.event.DomainEvent;
import multiwarehouse.payment_service.event.PaymentCreatedEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class ApplicationDomainEventPublisher implements
    ApplicationEventPublisherAware,
    DomainEvent<PaymentCreatedEvent>{
    
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void publish(PaymentCreatedEvent paymentCreatedEvent) {
        this.applicationEventPublisher.publishEvent(paymentCreatedEvent);
        Logger.getLogger(ApplicationDomainEventPublisher.class.getName()).info("PaymentCreatedEvent published");
    }
}

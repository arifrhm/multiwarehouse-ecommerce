package multiwarehouse.payment_service;

import multiwarehouse.common.domain.event.publisher.DomainEventPublisher;
import multiwarehouse.payment_service.entity.Payment;
import multiwarehouse.payment_service.event.PaymentUpdatedEvent;

public interface PaymentDomainService {
    void PaymentCreatedEvent createPayment(Payment payment);

    PaymentUpdatedEvent updatePayment(Payment payment, DomainEventPublisher<PaymentUpdatedEvent> paymentUpdatedEventDomainEventPublisher);
}


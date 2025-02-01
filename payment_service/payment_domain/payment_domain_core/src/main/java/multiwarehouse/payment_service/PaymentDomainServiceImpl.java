package multiwarehouse.payment_service;

import multiwarehouse.common.domain.event.publisher.DomainEventPublisher;
import multiwarehouse.payment_service.entity.Payment;
import multiwarehouse.payment_service.event.PaymentUpdatedEvent;

public class PaymentDomainServiceImpl implements PaymentDomainService {
    @Override
    public void createPayment(Payment payment, DomainEventPublisher<PaymentCreatedEvent> paymentCreatedEventDomainEventPublisher) {
        payment.initializePayment();
    }

    @Override
    public PaymentUpdatedEvent updatePayment(Payment payment, DomainEventPublisher<PaymentUpdatedEvent> paymentUpdatedEventDomainEventPublisher) {
        payment.updatePayment();
        return new PaymentUpdatedEvent(payment, paymentUpdatedEventDomainEventPublisher);
    }
}
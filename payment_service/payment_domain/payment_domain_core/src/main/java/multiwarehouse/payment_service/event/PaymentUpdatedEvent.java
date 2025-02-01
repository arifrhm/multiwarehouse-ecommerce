package multiwarehouse.payment_service.event;

import multiwarehouse.common.domain.event.publisher.DomainEventPublisher;
import multiwarehouse.payment_service.entity.Payment;

public class PaymentUpdatedEvent extends PaymentEvent{
    private final DomainEventPublisher<PaymentUpdatedEvent> paymentUpdatedEventDomainEventPublisher;

    public PaymentUpdatedEvent(Payment payment, DomainEventPublisher<PaymentUpdatedEvent> paymentUpdatedEventDomainEventPublisher) {
        super(payment);
        this.paymentUpdatedEventDomainEventPublisher = paymentUpdatedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        paymentUpdatedEventDomainEventPublisher.publish(this);
    }
}

package multiwarehouse.payment_service.event;

import multiwarehouse.common.domain.event.DomainEvent;
import multiwarehouse.payment_service.entity.Payment;

public abstract class PaymentEvent implements DomainEvent<Payment> {
    private final Payment payment;

    public PaymentEvent(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }
}
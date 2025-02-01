package multiwarehouse.payment_service.exception;

import multiwarehouse.common.domain.exception.DomainException;

public class PaymentNotFoundException extends DomainException {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}

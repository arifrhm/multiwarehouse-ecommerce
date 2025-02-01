package multiwarehouse.payment_service.exception;

import multiwarehouse.common.domain.exception.DomainException;

public class PaymentDomainException extends DomainException {
    public PaymentDomainException(String message) {
        super(message);
    }
}

package com.arifrhm.product.service.domain.exception;

import com.arifrhm.domain.exception.DomainException;

public class ProductNotFoundException extends DomainException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

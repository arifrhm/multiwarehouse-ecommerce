package com.arifrhm.order.service.domain.exception;


import com.arifrhm.domain.exception.DomainException;

public class OrderNotFoundException extends DomainException {
    public OrderNotFoundException(String message) {
        super(message);
    }
    public OrderNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}

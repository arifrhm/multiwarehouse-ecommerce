package com.arifrhm.warehouse.service.domain.exception;

public class WarehouseDomainException extends com.arifrhm.domain.exception.DomainException {

    public WarehouseDomainException(String message) {
        super(message);
    }

    public WarehouseDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.arifrhm.warehouse.service.domain.exception;

public class WarehouseNotFoundException extends com.arifrhm.domain.exception.DomainException {
    public WarehouseNotFoundException(String message) {
        super(message);
    }
    public WarehouseNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}

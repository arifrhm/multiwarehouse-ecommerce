package com.arifrhm.domain.event;

public interface DomainEvent<T> {

    void fire();
}

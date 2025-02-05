package com.arifrhm.user.service.domain.event;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.user.service.domain.entity.User;

import java.time.ZonedDateTime;

public class UserCreatedEvent extends UserEvent {

    private final DomainEventPublisher<UserCreatedEvent> userCreatedEventPublisher;

    public UserCreatedEvent(User user, ZonedDateTime createdAt, DomainEventPublisher<UserCreatedEvent> userCreatedEventPublisher) {
        super(user, createdAt);
        this.userCreatedEventPublisher = userCreatedEventPublisher;
    }

    @Override
    public void fire() {
        userCreatedEventPublisher.publish(this);
    }
}

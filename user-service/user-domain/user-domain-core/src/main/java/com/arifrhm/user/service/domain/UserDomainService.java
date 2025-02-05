package com.arifrhm.user.service.domain;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.user.service.domain.entity.User;
import com.arifrhm.user.service.domain.event.UserCreatedEvent;

public interface UserDomainService {

    UserCreatedEvent initializeUser(User user, DomainEventPublisher<UserCreatedEvent> publisher);

    boolean validateUserCredentials(User user, String password);

    String generateJwtToken(User user, String secretKey);
}

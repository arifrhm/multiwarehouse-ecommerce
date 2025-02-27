package com.arifrhm.user.service.domain;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.user.service.domain.entity.User;
import com.arifrhm.user.service.domain.event.UserCreatedEvent;
import com.arifrhm.user.service.domain.exception.UserDomainException;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class UserDomainServiceImpl implements UserDomainService {

    private static final String UTC = "UTC";

    @Override
    public UserCreatedEvent initializeUser(User user, DomainEventPublisher<UserCreatedEvent> publisher) {
        user.validateUser();
        user.initializeUser();
        user.generateToken("secretKey");

        log.info("User with email: {} is created", user.getEmail());
        return new UserCreatedEvent(user, ZonedDateTime.now(ZoneId.of(UTC)), publisher);
    }

    @Override
    public boolean validateUserCredentials(User user, String password) {
        if (user == null) {
            throw new UserDomainException("User not found.");
        }

        return user.verifyPassword(password);
    }

    @Override
    public String generateJwtToken(User user, String secretKey) {
        user.generateToken(secretKey);
        log.info("Generated JWT token for user with email: {}", user.getEmail());
        return user.getToken();
    }
}

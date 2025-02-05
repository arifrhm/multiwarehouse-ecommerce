package com.arifrhm.user.service.domain;

import com.arifrhm.user.service.domain.dto.post.RegisterCommand;
import com.arifrhm.user.service.domain.dto.response.UserResponse;
import com.arifrhm.user.service.domain.event.UserCreatedEvent;
import com.arifrhm.user.service.domain.mapper.UserDataMapper;
import com.arifrhm.user.service.domain.ports.output.message.publisher.UserCreatedEventPublisher;
import com.arifrhm.user.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegisterUserCommandHandler {

    private final UserHelper userHelper;
    private final UserDataMapper userDataMapper;
    private final UserCreatedEventPublisher userCreatedEventPublisher;

    public RegisterUserCommandHandler(UserHelper userHelper,
                                      UserDataMapper userDataMapper,
                                      UserCreatedEventPublisher userCreatedEventPublisher) {
        this.userHelper = userHelper;
        this.userDataMapper = userDataMapper;
        this.userCreatedEventPublisher = userCreatedEventPublisher;
    }

    public UserResponse registerUser(RegisterCommand registerCommand) {
        UserCreatedEvent userCreatedEvent = userHelper.persistUser(registerCommand);
        log.info("User with email: {} has been successfully registered", userCreatedEvent.getUser().getEmail());
        userCreatedEventPublisher.publish(userCreatedEvent);  // Publish user created event
        return userDataMapper.userToUserResponse(userCreatedEvent.getUser(), "User registered successfully");
    }
}

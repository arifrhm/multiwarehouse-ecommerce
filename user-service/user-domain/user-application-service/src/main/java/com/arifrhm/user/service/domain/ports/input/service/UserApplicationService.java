package com.arifrhm.user.service.domain.ports.input.service;

import com.arifrhm.user.service.domain.dto.response.UserResponse;
import com.arifrhm.user.service.domain.dto.post.LoginCommand;
import com.arifrhm.user.service.domain.dto.post.RegisterCommand;

import javax.validation.Valid;

public interface UserApplicationService {

    UserResponse registerUser(@Valid RegisterCommand registerCommand);

    UserResponse loginUser(@Valid LoginCommand loginCommand);

}

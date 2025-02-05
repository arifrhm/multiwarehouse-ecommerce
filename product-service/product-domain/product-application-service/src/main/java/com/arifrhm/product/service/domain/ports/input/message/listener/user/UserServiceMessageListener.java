package com.arifrhm.product.service.domain.ports.input.message.listener.user;


import com.arifrhm.product.service.domain.dto.message.UserResponseMessage;

public interface UserServiceMessageListener {

    void onUserRegistered(UserResponseMessage userResponseMessage);
}

package com.arifrhm.order.service.domain.ports.input.message.listener.user;


import com.arifrhm.order.service.domain.dto.message.UserResponseMessage;

public interface UserServiceMessageListener {

    void onUserRegistered(UserResponseMessage userResponseMessage);
}

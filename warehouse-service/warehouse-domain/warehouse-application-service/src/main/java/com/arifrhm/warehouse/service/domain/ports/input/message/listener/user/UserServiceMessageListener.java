package com.arifrhm.warehouse.service.domain.ports.input.message.listener.user;


import com.arifrhm.warehouse.service.domain.dto.message.OrderResponse;
import com.arifrhm.warehouse.service.domain.dto.message.UserResponseMessage;

public interface UserServiceMessageListener {

    void onUserRegistered(UserResponseMessage userResponseMessage);
}

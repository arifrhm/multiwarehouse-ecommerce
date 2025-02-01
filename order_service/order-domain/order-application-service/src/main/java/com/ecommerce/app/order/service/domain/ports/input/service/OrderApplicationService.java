package com.ecommerce.app.order.service.domain.ports.input.service;

import com.ecommerce.app.order.service.domain.dto.create.CreateOrderCommand;
import com.ecommerce.app.order.service.domain.dto.create.CreateOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
}

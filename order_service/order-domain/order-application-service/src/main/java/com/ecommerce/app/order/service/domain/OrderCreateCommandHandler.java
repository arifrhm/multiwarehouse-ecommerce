package com.ecommerce.app.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import com.ecommerce.app.order.service.domain.dto.create.CreateOrderCommand;
import com.ecommerce.app.order.service.domain.dto.create.CreateOrderResponse;
import com.ecommerce.app.order.service.domain.event.OrderCreatedEvent;
import com.ecommerce.app.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;
    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public OrderCreateCommandHandler(OrderCreateHelper orderCreateHelper,
                                     OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);
        return orderCreateHelper.orderToCreateOrderResponse(orderCreatedEvent.getOrder(), "Order created successfully");
    }
}

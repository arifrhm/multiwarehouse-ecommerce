package com.ecommerce.app.order.service.domain;

import com.ecommerce.app.order.service.domain.event.OrderCreatedEvent;
import com.ecommerce.app.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import com.ecommerce.app.order.service.domain.saga.OrderPaymentSaga;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderCreatedEventApplicationListener {

    private final OrderPaymentSaga orderPaymentSaga;
    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public OrderCreatedEventApplicationListener(OrderPaymentSaga orderPaymentSaga,
                                             OrderCreatedPaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher) {
        this.orderPaymentSaga = orderPaymentSaga;
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }

    @TransactionalEventListener
    void process(OrderCreatedEvent orderCreatedEvent) {
        orderPaymentSaga.process(orderCreatedEvent);
        log.info("Order created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
    }
}

package com.arifrhm.order.service.domain;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.order.service.domain.entity.Order;
import com.arifrhm.order.service.domain.entity.Stock;
import com.arifrhm.order.service.domain.entity.User;
import com.arifrhm.order.service.domain.entity.Warehouse;
import com.arifrhm.order.service.domain.event.OrderCreatedEvent;
import com.arifrhm.order.service.domain.event.OrderPaymentEvent;
import com.arifrhm.order.service.domain.exception.OrderDomainException;
import com.arifrhm.order.service.domain.valueobject.Invoice;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;


@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {


    private static final String UTC = "UTC";

    @Override
    public OrderCreatedEvent validateAndInitiateOrder(
            Order order,
            List<Stock> stocks,
            Warehouse nearestWarehouse,
            DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher) {

        order.validateOrderItems(stocks);

//        List<Stock> stocksNeedToTransfer = new java.util.ArrayList<>();
//        for (OrderItem orderItem: order.getItems()) {
//            stocksNeedToTransfer.addAll(order.findAndTransferStock(nearestWarehouse.getId(), stocks, orderItem.getProduct().getId(), orderItem.getQuantity()));
//        }
//
//        log.info(stocksNeedToTransfer.toString());

        order.validateOrder();
        order.initializeOrder();
        log.info("Order with id: {} is initiated", order.getId().getValue());
        return new OrderCreatedEvent(order, nearestWarehouse, ZonedDateTime.now(ZoneId.of(UTC)), orderCreatedEventDomainEventPublisher);
    }

    @Override
    public void invoicing(Order order, Invoice invoice) {
        order.invoicing(invoice);
        log.info("Order with id: {} is invoiced", order.getId().getValue());
    }

    @Override
    public void validateInitialWarehouse(Warehouse warehouse) {
        warehouse.validateInitializeWarehouse();
        log.info("Warehouse with id: {} is initialized", warehouse.getId().getValue());
    }


    private void validateSeller(Warehouse warehuse) {
        if (!warehuse.isActive()) {
            throw new OrderDomainException("Seller with id " + warehuse.getId().getValue() +
                    " is currently not active!");
        }
    }

    @Override
    public OrderPaymentEvent payOrder(Order order, DomainEventPublisher<OrderPaymentEvent> orderPaymentEventDomainEventPublisher) {
        order.validatePayOrder();
        order.payOrder();
        log.info("Order with id: {} is paid", order.getId().getValue());
        return new OrderPaymentEvent(order, ZonedDateTime.now(ZoneId.of(UTC)), orderPaymentEventDomainEventPublisher);
    }

    @Override
    public OrderPaymentEvent cancelOrder(Order order, DomainEventPublisher<OrderPaymentEvent> orderPaymentEventDomainEventPublisher) {
        order.cancelOrder();
        log.info("Order with id: {} is cancelled", order.getId().getValue());
        return new OrderPaymentEvent(order, ZonedDateTime.now(ZoneId.of(UTC)), orderPaymentEventDomainEventPublisher);
    }

    @Override
    public void createUser(User user){
        user.validateUser();
        log.info("User with email: {} is created", user.getEmail());
    }
}

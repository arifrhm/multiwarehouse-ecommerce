package com.ecommerce.app.order.service.domain.ports.output.repository;

import com.ecommerce.common.domain.valueobject.OrderId;
import com.ecommerce.app.order.service.domain.entity.Order;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId orderId);

    Optional<Order> findByTrackingId(OrderId trackingId);
}

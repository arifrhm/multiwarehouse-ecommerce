package com.arifrhm.order.service.domain.ports.output.repository;

import com.arifrhm.domain.valueobject.OrderId;
import com.arifrhm.order.service.domain.entity.Order;
import com.arifrhm.order.service.domain.valueobject.TrackingId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId orderId);

    Optional<Order> findByTrackingId(TrackingId trackingId);

    Page<Order> findAll(Pageable pageable); // Add pagination support

    Page<Order> findByUserId(UUID userId, Pageable pageable); // Add pagination support>

    List<Object[]> findTotalOrdersByDay(LocalDate startDate, LocalDate endDate);

    int payOrder(Order order);

    Optional<Order> findByIdWithItems(OrderId orderId);

    Optional<List<Order>> findExpiredOrders();

    int cancelOrder(Order order);
}

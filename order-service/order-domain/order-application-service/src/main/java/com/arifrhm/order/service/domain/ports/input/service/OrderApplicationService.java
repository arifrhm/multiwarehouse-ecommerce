package com.arifrhm.order.service.domain.ports.input.service;

import com.arifrhm.order.service.domain.dto.create.*;
import com.arifrhm.order.service.domain.dto.track.TrackOrderQuery;
import com.arifrhm.order.service.domain.dto.track.TrackOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);

//    OrderResponse getAllByCustomerId();

    OrderListResponse getAllOrders(int page, int size);

    OrderListResponse getAllOrdersByCustomerId(String customerId, int page, int size);

    OrderStatsResponse getLastWeekOrderStat();

    OrderResponse payment(String orderId);

    void cancel();


}

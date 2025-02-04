package com.arifrhm.warehouse.service.dataaccess.orderStockMutation.adapter;

import com.arifrhm.domain.valueobject.OrderId;
import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.dataaccess.orderStockMutation.mapper.OrderStockMutationDataMapper;
import com.arifrhm.warehouse.service.dataaccess.orderStockMutation.repository.OrderStockMutationJpaRepository;
import com.arifrhm.warehouse.service.domain.entity.OrderStockMutation;
import com.arifrhm.warehouse.service.domain.ports.output.repository.OrderStockMutationRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderStockMutationRepositoryImpl implements OrderStockMutationRepository {

    private final OrderStockMutationJpaRepository orderStockMutationJpaRepository;
    private final OrderStockMutationDataMapper orderStockMutationDataMapper;

    public OrderStockMutationRepositoryImpl(OrderStockMutationJpaRepository orderStockMutationJpaRepository, OrderStockMutationDataMapper orderStockMutationDataMapper) {
        this.orderStockMutationJpaRepository = orderStockMutationJpaRepository;
        this.orderStockMutationDataMapper = orderStockMutationDataMapper;
    }


    @Override
    public OrderStockMutation save(OrderStockMutation orderStockMutation){
        return orderStockMutationDataMapper.orderStockMutationEntityToOrderStockMutationDataMapper(
                orderStockMutationJpaRepository.save(orderStockMutationDataMapper.orderStockMutationToOrderStockMutationEntityDataMapper(orderStockMutation)));
    }

    @Override
    public Optional<OrderStockMutation> findByWarehouseIdAndProductId(WarehouseId warehouseId, ProductId productId) {
        return orderStockMutationJpaRepository.findByWarehouseIdAndProductId(warehouseId.getValue(), productId.getValue())
                .map(orderStockMutationDataMapper::orderStockMutationEntityToOrderStockMutationDataMapper);
    }

    @Override
    public void updateStatusStockMutation(OrderStockMutation orderStockMutation) {
        orderStockMutationJpaRepository.updateStatusStockMutation(orderStockMutation.getId().getValue(), orderStockMutation.getStatusStockMutation());
    }

    @Override
    public Optional<List<OrderStockMutation>> findByOrderId(OrderId orderId) {
        return orderStockMutationJpaRepository.findByOrderId(orderId.getValue())
                .map(entities -> entities.stream()
                        .map(orderStockMutationDataMapper::orderStockMutationEntityToOrderStockMutationDataMapper)
                        .collect(Collectors.toList()));
    }
}

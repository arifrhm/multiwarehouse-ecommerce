package com.arifrhm.order.service.domain;

import com.arifrhm.order.service.domain.dto.message.WarehouseResponseMessage;
import com.arifrhm.order.service.domain.entity.Warehouse;
import com.arifrhm.order.service.domain.mapper.OrderDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class WarehouseSaveSaga {

    private final OrderDomainService orderDomainService;
    private final OrderSagaHelper sagaHelper;
    private final OrderDataMapper orderDataMapper;


    public WarehouseSaveSaga(OrderDomainService orderDomainService,
                             OrderSagaHelper sagaHelper,
                            OrderDataMapper orderDataMapper) {
        this.orderDomainService = orderDomainService;
        this.sagaHelper = sagaHelper;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional
    public void process(WarehouseResponseMessage warehouseResponseMessage) {
        log.info("Processing save warehouse id: {}", warehouseResponseMessage.getWarehoudId());

        Warehouse warehouse = orderDataMapper.warehouseResponseToWarehouse(warehouseResponseMessage);
        orderDomainService.validateInitialWarehouse(warehouse);

        sagaHelper.saveWarehouse(warehouse);

        log.info("Save warehouse is completed with id: {}", warehouse.getId().getValue());
    }
}

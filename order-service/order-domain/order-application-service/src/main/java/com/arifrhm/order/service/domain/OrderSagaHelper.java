package com.arifrhm.order.service.domain;

import com.arifrhm.order.service.domain.entity.Warehouse;
import com.arifrhm.order.service.domain.ports.output.repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderSagaHelper {

    private final WarehouseRepository warehouseRepository;

    public OrderSagaHelper(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }


    public void saveWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }
}

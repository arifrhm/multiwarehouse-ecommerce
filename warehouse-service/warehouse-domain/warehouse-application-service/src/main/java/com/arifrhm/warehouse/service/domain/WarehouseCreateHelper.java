package com.arifrhm.warehouse.service.domain;

import com.arifrhm.warehouse.service.domain.dto.create.CreateWarehouseCommand;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import com.arifrhm.warehouse.service.domain.event.WarehouseCreatedEvent;
import com.arifrhm.warehouse.service.domain.exception.WarehouseDomainException;
import com.arifrhm.warehouse.service.domain.mapper.WarehouseDataMapper;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.WarehouseCreatedEventPublisher;
import com.arifrhm.warehouse.service.domain.ports.output.repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class WarehouseCreateHelper {

    private final WarehouseDomainService warehouseDomainService;
    private final WarehouseRepository warehouseRepository;
    private final WarehouseDataMapper warehouseDataMapper;
    private final WarehouseCreatedEventPublisher warehouseCreatedEventPublisher;

    public WarehouseCreateHelper(WarehouseDomainService warehouseDomainService,
                                 WarehouseRepository warehouseRepository,
                                 WarehouseDataMapper warehouseDataMapper,
                                 WarehouseCreatedEventPublisher warehouseCreatedEventPublisher) {
        this.warehouseDomainService = warehouseDomainService;
        this.warehouseRepository = warehouseRepository;
        this.warehouseDataMapper = warehouseDataMapper;
        this.warehouseCreatedEventPublisher = warehouseCreatedEventPublisher;
    }

    @Transactional
    public WarehouseCreatedEvent persistWarehouse(CreateWarehouseCommand createWarehouseCommand) {
        Warehouse warehouse = warehouseDataMapper.createWarehouseCommandToWarehouse(createWarehouseCommand);
        WarehouseCreatedEvent warehouseCreatedEvent = warehouseDomainService.validateAndInitializeWarehouse(warehouse, warehouseCreatedEventPublisher);
        saveWarehouse(warehouse);
        log.info("Warehouse is created with id: {}", warehouseCreatedEvent.getWarehouse().getId().getValue());
        return warehouseCreatedEvent;
    }

    private void saveWarehouse(Warehouse warehouse) {
        Warehouse savedWarehouse = warehouseRepository.save(warehouse);
        if (savedWarehouse == null) {
            log.error("Could not save warehouse!");
            throw new WarehouseDomainException("Could not save warehouse!");
        }
        log.info("Warehouse is saved with id: {}", savedWarehouse.getId().getValue());
    }
}

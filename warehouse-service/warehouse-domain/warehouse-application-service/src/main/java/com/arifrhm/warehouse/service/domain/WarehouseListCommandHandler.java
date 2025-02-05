package com.arifrhm.warehouse.service.domain;

import com.arifrhm.warehouse.service.domain.dto.create.WarehouseListResponse;
import com.arifrhm.warehouse.service.domain.mapper.WarehouseDataMapper;
import com.arifrhm.warehouse.service.domain.ports.output.repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WarehouseListCommandHandler {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseDataMapper warehouseDataMapper;

    public WarehouseListCommandHandler(WarehouseRepository warehouseRepository, WarehouseDataMapper warehouseDataMapper) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseDataMapper = warehouseDataMapper;
    }

    public WarehouseListResponse listWarehouses(int page, int size) {
        log.info("Listing warehouses for page: {} with size: {}", page, size);
        return warehouseDataMapper.warehousePageToWarehouseListResponse(
                warehouseRepository.findAll(PageRequest.of(page, size)));
    }
}

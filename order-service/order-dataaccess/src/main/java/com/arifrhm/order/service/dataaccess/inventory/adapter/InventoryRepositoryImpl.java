package com.arifrhm.order.service.dataaccess.inventory.adapter;

import com.arifrhm.dataaccess.inventory.repository.InventoryJpaRepository;
import com.arifrhm.order.service.dataaccess.inventory.mapper.InventoryDataAccessMapper;
import com.arifrhm.order.service.domain.ports.output.repository.InventoryRepository;
import org.springframework.stereotype.Component;


@Component
public class InventoryRepositoryImpl implements InventoryRepository {
    private final InventoryJpaRepository inventoryJpaRepository;
    private final InventoryDataAccessMapper inventoryDataAccessMapper;

    public InventoryRepositoryImpl(InventoryJpaRepository inventoryJpaRepository, InventoryDataAccessMapper inventoryDataAccessMapper) {
        this.inventoryJpaRepository = inventoryJpaRepository;
        this.inventoryDataAccessMapper = inventoryDataAccessMapper;
    }



}

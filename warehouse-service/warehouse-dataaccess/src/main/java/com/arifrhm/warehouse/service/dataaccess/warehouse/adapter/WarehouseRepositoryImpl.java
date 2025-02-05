package com.arifrhm.warehouse.service.dataaccess.warehouse.adapter;

import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.dataaccess.warehouse.entity.WarehouseEntity;
import com.arifrhm.warehouse.service.dataaccess.warehouse.mapper.WarehouseDataAccessMapper;
import com.arifrhm.warehouse.service.dataaccess.warehouse.repository.WarehouseJpaRepository;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import com.arifrhm.warehouse.service.domain.ports.output.repository.WarehouseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class WarehouseRepositoryImpl implements WarehouseRepository {

    private final WarehouseJpaRepository warehouseJpaRepository;
    private final WarehouseDataAccessMapper warehouseDataAccessMapper;

    public WarehouseRepositoryImpl(WarehouseJpaRepository warehouseJpaRepository, WarehouseDataAccessMapper warehouseDataAccessMapper){
        this.warehouseJpaRepository = warehouseJpaRepository;
        this.warehouseDataAccessMapper = warehouseDataAccessMapper;
    }

    @Override
    public Warehouse save(Warehouse warehouse){
        return warehouseDataAccessMapper.warehouseEntityToWarehouse(warehouseJpaRepository
                .save(warehouseDataAccessMapper.warehouseToWarehouseDataMapper(warehouse)));
    }

    @Override
    public Optional<Warehouse> findById(WarehouseId warehouseId){
        Optional<WarehouseEntity> warehouseEntity = warehouseJpaRepository.findById(warehouseId.getValue());

        return warehouseJpaRepository.findById(warehouseId.getValue()).map(warehouseDataAccessMapper::warehouseEntityToWarehouse);
    }

    @Override
    public Page<Warehouse> findAll(Pageable pageable) {
        return warehouseJpaRepository.findAll(pageable)
                .map(warehouseDataAccessMapper::warehouseEntityToWarehouse);
    }

    @Override
    public void delete(Warehouse warehouse){
        warehouseJpaRepository.delete(
                warehouseDataAccessMapper.warehouseToWarehouseDataMapper(warehouse)
        );
    }}

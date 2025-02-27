package com.arifrhm.order.service.dataaccess.warehouse.adapter;

import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.order.service.dataaccess.warehouse.mapper.WarehouseDataAccessMapper;
import com.arifrhm.order.service.dataaccess.warehouse.repository.WarehouseJpaRepository;
import com.arifrhm.order.service.domain.entity.Warehouse;
import com.arifrhm.order.service.domain.ports.output.repository.WarehouseRepository;
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
    public Optional<Warehouse> findById(WarehouseId warehouseId){
        return warehouseJpaRepository.findById(warehouseId.getValue()).map(warehouseDataAccessMapper::warehouseEntityToWarehouse);
    }


    @Override
    public void save(Warehouse warehouse){
        warehouseJpaRepository.save(warehouseDataAccessMapper.warehouseToWarehouseEntity(warehouse));
    }

    @Override
    public Optional<Warehouse> findNearestLocation(double latitude, double longitude) {
        return warehouseJpaRepository.findNearestLocation(latitude, longitude).map(warehouseDataAccessMapper::warehouseEntityToWarehouse);
    }



}

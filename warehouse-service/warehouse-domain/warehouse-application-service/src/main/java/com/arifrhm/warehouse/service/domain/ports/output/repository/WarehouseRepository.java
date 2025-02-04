package com.arifrhm.warehouse.service.domain.ports.output.repository;

import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface WarehouseRepository {

    Warehouse save(Warehouse warehouse);

    Optional<Warehouse> findById(WarehouseId warehouseId);

    Page<Warehouse> findAll(Pageable pageable); // Updated for pagination



    void delete(Warehouse warehouse);
}

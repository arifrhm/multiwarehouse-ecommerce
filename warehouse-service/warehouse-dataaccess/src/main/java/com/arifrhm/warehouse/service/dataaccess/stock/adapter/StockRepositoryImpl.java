package com.arifrhm.warehouse.service.dataaccess.stock.adapter;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.dataaccess.stock.mapper.StockDataAccessMapper;
import com.arifrhm.warehouse.service.dataaccess.stock.repository.StockJpaRepository;
import com.arifrhm.warehouse.service.domain.entity.Stock;
import com.arifrhm.warehouse.service.domain.ports.output.repository.StockRepository;
import com.arifrhm.warehouse.service.domain.valueobject.StockTransfer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StockRepositoryImpl implements StockRepository {

    private final StockJpaRepository stockJpaRepository;
    private final StockDataAccessMapper stockDataAccessMapper;

    public StockRepositoryImpl(StockJpaRepository stockJpaRepository, StockDataAccessMapper stockDataAccessMapper) {
        this.stockJpaRepository = stockJpaRepository;
        this.stockDataAccessMapper = stockDataAccessMapper;
    }

    @Override
    public Stock save(Stock stock) {
        return stockDataAccessMapper.stockEntityToStock(stockJpaRepository
                .save(stockDataAccessMapper.stockToStockEntityDataMapper(stock)));
    }

//    @Override
//    public Optional<Stock> findById(StockId stockId) {
//        return stockJpaRepository.findById(stockId.getValue()).map(stockDataAccessMapper::stockEntityToStock);
//    }

//    testing
    @Override
    public StockTransfer saveStockTransfer(StockTransfer stockTransfer){
        return stockTransfer;
    }


    @Override
    public Optional<Stock> findByWarehouseIdAndProductId(WarehouseId warehouseId, ProductId productId) {
        return stockJpaRepository.findByWarehouseIdAndProductId(warehouseId.getValue(), productId.getValue())
                .map(stockDataAccessMapper::stockEntityToStock);
    }

    @Override
    public List<Stock> findByWarehouseId(WarehouseId warehouseId) {
        return stockJpaRepository.findByWarehouseId(warehouseId.getValue()).stream()
                .map(stockDataAccessMapper::stockEntityToStock)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Stock stock) {
        stockJpaRepository.delete(stockDataAccessMapper.stockToStockEntityDataMapper(stock));
    }

    @Override
    public Optional<List<Stock>> findByProductIdIn(List<ProductId> productIds) {
        return stockJpaRepository.findByProductIdIn(productIds.stream().map(ProductId::getValue).collect(Collectors.toList()))
                .map(stocks -> stocks.stream().map(stockDataAccessMapper::stockEntityToStock).collect(Collectors.toList()));
    }

    @Override
    public Integer getProductTotalQuantity(ProductId productId) {
        return stockJpaRepository.getProductTotalQuantity(productId.getValue());
    }
}

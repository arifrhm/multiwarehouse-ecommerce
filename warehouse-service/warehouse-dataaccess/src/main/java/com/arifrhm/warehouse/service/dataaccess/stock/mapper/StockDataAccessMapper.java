package com.arifrhm.warehouse.service.dataaccess.stock.mapper;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.StockId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.dataaccess.stock.entity.StockEntity;
import com.arifrhm.warehouse.service.domain.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockDataAccessMapper {

    public StockEntity stockToStockEntityDataMapper(Stock stock){
         return StockEntity.builder()
                 .id(stock.getId().getValue())
                 .warehouseId(stock.getWarehouseId().getValue())
                 .productId(stock.getProductId().getValue())
                 .quantity(stock.getQuantity())
                 .build();
    }

    public Stock stockEntityToStock(StockEntity stockEntity){
        return Stock.builder()
                .stockId(new StockId(stockEntity.getId()))
                .warehouseId(new WarehouseId(stockEntity.getWarehouseId()))
                .productId(new ProductId(stockEntity.getProductId()))
                .quantity(stockEntity.getQuantity())
                .build();
    }

}

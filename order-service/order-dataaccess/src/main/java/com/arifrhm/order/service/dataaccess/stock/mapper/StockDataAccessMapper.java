package com.arifrhm.order.service.dataaccess.stock.mapper;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.StockId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.order.service.dataaccess.stock.entity.StockEntity;
import com.arifrhm.order.service.domain.entity.Stock;
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
        return new Stock(
                new StockId(stockEntity.getId()),
                new WarehouseId(stockEntity.getWarehouseId()),
                new ProductId(stockEntity.getProductId()),
                stockEntity.getQuantity());
    }

}

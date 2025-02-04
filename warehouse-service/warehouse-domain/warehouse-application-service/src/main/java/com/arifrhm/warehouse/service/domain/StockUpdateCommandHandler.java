package com.arifrhm.warehouse.service.domain;

import com.arifrhm.warehouse.service.domain.dto.create.CreateUpdateStockCommand;
import com.arifrhm.warehouse.service.domain.dto.create.CreateStockResponse;
import com.arifrhm.warehouse.service.domain.event.StockCreatedEvent;
import com.arifrhm.warehouse.service.domain.event.StockEvent;
import com.arifrhm.warehouse.service.domain.event.StockUpdatedEvent;
import com.arifrhm.warehouse.service.domain.mapper.WarehouseDataMapper;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockCreatedEventPublisher;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockUpdatedEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StockUpdateCommandHandler {

    private final StockUpdateHelper stockUpdateHelper;
    private final WarehouseDataMapper warehouseDataMapper;
    private  final StockCreatedEventPublisher stockCreatedEventPublisher;
    private final StockUpdatedEventPublisher stockUpdatedEventPublisher;


    public StockUpdateCommandHandler(StockUpdateHelper stockUpdateHelper,
                                     WarehouseDataMapper warehouseDataMapper,
                                     StockCreatedEventPublisher stockCreatedEventPublisher,
                                     StockUpdatedEventPublisher stockUpdatedEventPublisher) {
        this.stockUpdateHelper = stockUpdateHelper;
        this.warehouseDataMapper = warehouseDataMapper;
        this.stockUpdatedEventPublisher = stockUpdatedEventPublisher;
        this.stockCreatedEventPublisher = stockCreatedEventPublisher;
    }

    public CreateStockResponse updateStock(CreateUpdateStockCommand updateStockCommand) {
        StockEvent stockEvent = stockUpdateHelper.processStockUpdate(updateStockCommand);

        if (stockEvent instanceof StockUpdatedEvent) {
            log.info("Stock updated successfully for product ID: {} in warehouse ID: {}",
                    updateStockCommand.getProductId(), updateStockCommand.getWarehouseId());

            StockUpdatedEvent stockUpdatedEvent = (StockUpdatedEvent) stockEvent;
            stockUpdatedEventPublisher.publish(stockUpdatedEvent);

        }

        if (stockEvent instanceof StockCreatedEvent){
            log.info("Stock created successfully for product ID: {} in warehouse ID: {}",
                    updateStockCommand.getProductId(), updateStockCommand.getWarehouseId());

            StockCreatedEvent stockCreatedEvent = (StockCreatedEvent) stockEvent;
            stockCreatedEventPublisher.publish(stockCreatedEvent);
        }


        return warehouseDataMapper.stockToCreateStockResponse(stockEvent.getStock(),
                "Stock updated successfully");
    }
}

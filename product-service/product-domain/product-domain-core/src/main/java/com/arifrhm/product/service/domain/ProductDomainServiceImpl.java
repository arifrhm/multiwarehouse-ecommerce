package com.arifrhm.product.service.domain;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.product.service.domain.entity.Product;
import com.arifrhm.product.service.domain.event.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class ProductDomainServiceImpl implements ProductDomainService {

    private static final String UTC = "UTC";

    @Override
    public ProductCreatedEvent initializeProduct(Product product, DomainEventPublisher<ProductCreatedEvent> publisher) {
        product.validateProduct();
        product.initializeProduct();

        log.info("Product with id: {} is created", product.getId());
        return new ProductCreatedEvent(product, ZonedDateTime.now(ZoneId.of(UTC)), publisher);
    }

    @Override
    public void patchProduct(Product product, Integer totalStock) {
        product.updateTotalStock(totalStock);
        log.info("Product with id: {} is updated", product.getId());
    }


}

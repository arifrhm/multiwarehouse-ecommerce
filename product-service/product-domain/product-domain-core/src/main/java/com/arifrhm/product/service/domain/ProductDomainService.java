package com.arifrhm.product.service.domain;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.product.service.domain.entity.Product;
import com.arifrhm.product.service.domain.event.ProductCreatedEvent;

public interface ProductDomainService {

    ProductCreatedEvent initializeProduct(Product product, DomainEventPublisher<ProductCreatedEvent> publisher);

    void patchProduct(Product product, Integer totalStock);

}

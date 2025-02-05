package com.arifrhm.order.service.domain.ports.output.repository;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.order.service.domain.entity.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(ProductId productId);

    Product save(Product product);

    void delete(Product product);
}

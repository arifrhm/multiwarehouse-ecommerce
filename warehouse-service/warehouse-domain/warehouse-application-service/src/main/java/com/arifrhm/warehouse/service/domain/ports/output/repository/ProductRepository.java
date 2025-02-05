package com.arifrhm.warehouse.service.domain.ports.output.repository;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.warehouse.service.domain.entity.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(ProductId productId);

    Product save(Product product);

    void delete(Product product);
}

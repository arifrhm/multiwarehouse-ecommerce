package com.arifrhm.product.service.domain.ports.output.repository;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.product.service.domain.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(ProductId productId);

    Page<Product> findAll(Pageable pageable); // Updated for pagination
}

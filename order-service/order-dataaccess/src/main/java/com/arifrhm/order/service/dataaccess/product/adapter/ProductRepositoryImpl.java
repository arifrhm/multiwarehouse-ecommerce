package com.arifrhm.order.service.dataaccess.product.adapter;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.order.service.dataaccess.product.mapper.ProductDataAccessMapper;
import com.arifrhm.order.service.dataaccess.product.repository.ProductJpaRepository;
import com.arifrhm.order.service.domain.entity.Product;
import com.arifrhm.order.service.domain.ports.output.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;
    private final ProductDataAccessMapper productDataAccessMapper;

    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository, ProductDataAccessMapper productDataAccessMapper){
        this.productJpaRepository = productJpaRepository;
        this.productDataAccessMapper = productDataAccessMapper;
    }

    @Override
    public Product save(Product product){
        return productDataAccessMapper.productEntityToProductDataMapper(productJpaRepository
                .save(productDataAccessMapper.productToProductEntityDataMapper(product)));
    }

    @Override
    public Optional<Product> findById(ProductId productId){
        return productJpaRepository.findById(productId.getValue()).map(productDataAccessMapper::productEntityToProductDataMapper);
    }


    @Override
    public void delete(Product product){
        productJpaRepository.delete(
                productDataAccessMapper.productToProductEntityDataMapper(product)
        );
    }}

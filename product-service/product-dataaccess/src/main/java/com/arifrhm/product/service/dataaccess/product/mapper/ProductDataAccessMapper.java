package com.arifrhm.product.service.dataaccess.product.mapper;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.product.service.dataaccess.product.entity.ProductEntity;
import com.arifrhm.product.service.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDataAccessMapper {

    public ProductEntity productToProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId().getValue())
                .name(product.getName())
                .price(product.getPrice())
                .totalStock(product.getTotalStock())
                .imageUrl(product.getImageUrl())
                .build();
    }

    public Product productEntityToProduct(ProductEntity productEntity) {
        return Product.builder()
                .productId(new ProductId(productEntity.getId()))
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .totalStock(productEntity.getTotalStock())
                .imageUrl(productEntity.getImageUrl())
                .build();
    }
}

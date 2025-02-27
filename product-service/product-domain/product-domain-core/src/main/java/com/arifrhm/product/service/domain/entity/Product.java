package com.arifrhm.product.service.domain.entity;

import com.arifrhm.domain.entity.AggregateRoot;
import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.product.service.domain.exception.ProductDomainException;

import java.math.BigDecimal;
import java.util.UUID;

public class Product extends AggregateRoot<ProductId> {

    private String name;
    private BigDecimal price;
    private Integer totalStock;
    private String imageUrl; // New field

    private Product(Builder builder) {
        super.setId(builder.productId);
        this.name = builder.name;
        this.price = builder.price;
        this.totalStock =  builder.totalStock;
        this.imageUrl = builder.imageUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void validateProduct() {
        validateName();
        validatePrice();
        validateImageUrl();

    }

    // initialize product
    public void initializeProduct() {
        setId(new ProductId(UUID.randomUUID()));
        this.totalStock = 0;
    }

    private void validateName() {
        if (name == null || name.trim().isEmpty()) {
            throw new ProductDomainException("Product name cannot be null or empty.");
        }
    }

    private void validatePrice() {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductDomainException("Product price must be greater than zero.");
        }
    }

    private void validateImageUrl() {
        if (imageUrl == null || imageUrl.trim().isEmpty()) {
            throw new ProductDomainException("Product image URL cannot be null or empty.");
        }
    }

    public void updateProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public void updateTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    // Getters
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static final class Builder {
        private ProductId productId;
        private String name;
        private BigDecimal price;
        private Integer totalStock;
        private String imageUrl; // New field

        private Builder() {}

        public Builder productId(ProductId productId) {
            this.productId = productId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder totalStock(Integer totalStock) {
            this.totalStock = totalStock;
            return this;
        }

        public Builder imageUrl(String imageUrl) { // New setter
            this.imageUrl = imageUrl;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}

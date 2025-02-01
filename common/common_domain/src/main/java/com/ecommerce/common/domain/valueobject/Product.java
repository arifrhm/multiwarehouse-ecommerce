package multiwarehouse.common.domain.valueobject;

import multiwarehouse.common.domain.entity.BaseEntity;

public class Product extends BaseEntity<ProductId> {
    private final String sku;
    
    private String name;

    private Money price;

    private String description;

    public Product(ProductId id, String sku, String name, Money price, String description) {
        super.setId(id);
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void updateProduct(String name, Money price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

package multiwarehouse.ecommerce.order.service.domain.entity;

import lombok.Getter;
import multiwarehouse.common.domain.entity.AggregateRoot;
import multiwarehouse.common.domain.valueobject.SellerId;

import java.util.List;

@Getter
public class Seller extends AggregateRoot<SellerId> {
    private final String name;
    private final List<Product> products;
    private final boolean active;

    public Seller(SellerId sellerId, String name, List<Product> products, boolean active) {
        super.setId(sellerId);
        this.name = name;
        this.products = products;
        this.active = active;
    }
}

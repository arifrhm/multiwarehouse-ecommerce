package multiwarehouse.order_service.entity;

import multiwarehouse.common.domain.entity.BaseEntity;
import multiwarehouse.common.domain.valueobject.Money;
import multiwarehouse.common.domain.valueobject.OrderId;
import multiwarehouse.common.domain.valueobject.ProductId;
import multiwarehouse.common.domain.valueobject.WarehouseId;
import multiwarehouse.order_service.valueobject.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {
    private OrderId orderId;
    private final ProductId productId;
    private final String productName;
    private final WarehouseId warehouseId;
    private final int quantity;
    private final Money price;
    private final Money subtotal;

    public static final class Builder {
        private OrderItemId orderItemId;
        private ProductId productId;
        private String productName;
        private WarehouseId warehouseId;
        private int quantity;
        private Money price;
        private Money subtotal;

        private Builder() {
        }

        public OrderItem build() {
            return new OrderItem(this);
        }

        public Builder withOrderItemId(OrderItemId orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }

        public Builder withProductId(ProductId productId) {
            this.productId = productId;
            return this;
        }

        public Builder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder withWarehouseId(WarehouseId warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        public Builder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder withPrice(Money price) {
            this.price = price;
            return this;
        }

        public Builder withSubtotal(Money subtotal) {
            this.subtotal = subtotal;
            return this;
        }
    }

    void initializeOrderItem(OrderId orderId, OrderItemId orderItemId) {
        this.orderId = orderId;
        super.setId(orderItemId);
    }

    boolean isPriceValid() {
        return this.price != null && this.price.isGreaterThanZero();
    }

    boolean isSubtotalValid() {
        return this.subtotal != null && this.subtotal.isGreaterThanZero();
    }

    private OrderItem(Builder builder) {
        super.setId(builder.orderItemId);
        productId = builder.productId;
        productName = builder.productName;
        warehouseId = builder.warehouseId;
        quantity = builder.quantity;
        price = builder.price;
        subtotal = builder.subtotal;
    }

    public static Builder builder() {
        return new Builder();
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }

    public Money getSubtotal() {
        return subtotal;
    }
}
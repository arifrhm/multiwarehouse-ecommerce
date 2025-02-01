// package multiwarehouse.order_service.dto.create;

// import java.util.UUID;

// import multiwarehouse.common.domain.valueobject.Money;

// public class OrderItem {
//     @NotNull
//     private final UUID id;
    
//     @NotNull
//     private final UUID orderId;

//     @NotNull
//     private final UUID productId;

//     @NotNull
//     private final UUID warehouseId;

//     @NotNull
//     private final String productName;

//     @NotNull
//     private final int quantity;

//     @NotNull
//     private final Money price;

//     @NotNull
//     private final Money subtotal;

//     public OrderItem(UUID id, String productName, UUID orderId, Money price, UUID productId, int quantity, Money subtotal, UUID warehouseId) {
//         this.id = id;
//         this.productName = productName;
//         this.orderId = orderId;
//         this.price = price;
//         this.productId = productId;
//         this.quantity = quantity;
//         this.subtotal = subtotal;
//         this.warehouseId = warehouseId;
//     }
// }

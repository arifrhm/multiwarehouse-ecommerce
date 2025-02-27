package com.arifrhm.product.service.domain.mapper;

import com.arifrhm.domain.valueobject.UserId;
import com.arifrhm.domain.valueobject.UserRole;
import com.arifrhm.product.service.domain.dto.message.UserResponseMessage;
import com.arifrhm.product.service.domain.dto.post.CreateProductCommand;
import com.arifrhm.product.service.domain.dto.response.ProductListResponse;
import com.arifrhm.product.service.domain.dto.response.ProductResponse;
import com.arifrhm.product.service.domain.entity.Product;
import com.arifrhm.product.service.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProductDataMapper {

    public Product productCommandToProduct(CreateProductCommand productCommand) {
        return Product.builder()
                .name(productCommand.getName())
                .price(productCommand.getPrice())
                .imageUrl(productCommand.getImageUrl())
                .build();
    }

    public ProductResponse productToProductResponse(Product product, String message) {
        return ProductResponse.builder()
                .productId(product.getId().getValue())
                .name(product.getName())
                .price(product.getPrice())
                .totalStock(product.getTotalStock())
                .imageUrl(product.getImageUrl())
                .message(message)
                .build();
    }

    public ProductListResponse productPageToProductListResponse(Page<Product> productPage) {
        List<ProductResponse> productResponses = productPage.getContent().stream()
                .map(product -> ProductResponse.builder()
                        .productId(product.getId().getValue())
                        .name(product.getName())
                        .price(product.getPrice())
                        .imageUrl(product.getImageUrl())
                        .totalStock(product.getTotalStock())
                        .build())
                .collect(Collectors.toList());

        return ProductListResponse.builder()
                .products(productResponses)
                .totalElements(productPage.getTotalElements())
                .totalPages(productPage.getTotalPages())
                .currentPage(productPage.getNumber())
                .build();
    }

    public User userResponseMessageToUser(UserResponseMessage userResponseMessage) {
        return new User(
                new UserId(UUID.fromString(userResponseMessage.getUserId())),
                userResponseMessage.getName(),
                userResponseMessage.getEmail(),
                UserRole.valueOf(userResponseMessage.getRole()),
                userResponseMessage.isActive(),
                userResponseMessage.getToken()
        );
    }
}

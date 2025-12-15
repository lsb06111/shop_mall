package com.example.shop_api.dto.product;

import com.example.shop_api.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private int price;
    private int stock;
    private String categoryName;
    private List<ProductImageResponse> imageResponses;

    public static ProductResponse from(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .categoryName(product.getCategory().getName())
                .imageResponses(product.getProductImages().stream()
                        .map(ProductImageResponse::from)
                        .toList()
                )
                .build();
    }
    
}

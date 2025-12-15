package com.example.shop_api.dto.product;

import com.example.shop_api.domain.product.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductImageResponse {
    private String slug;
    private String altText;
    private int sortOrder;

    public static ProductImageResponse from(ProductImage image) {
        return ProductImageResponse.builder()
                .slug(image.getSlug())
                .altText(image.getAltText())
                .sortOrder(image.getSortOrder())
                .build();
    }
}

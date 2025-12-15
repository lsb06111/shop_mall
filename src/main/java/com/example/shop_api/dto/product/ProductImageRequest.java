package com.example.shop_api.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

@Getter
public class ProductImageRequest {

    @NotBlank(message = "이미지 slug는 필수입니다.")
    private String slug;

    private String altText;

    @PositiveOrZero(message = "정렬 순서는 0 이상이어야 합니다.")
    private int sortOrder;
}

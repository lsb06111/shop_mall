package com.example.shop_api.dto.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductCreateRequest {

    @NotBlank(message = "상품명은 필수입니다.")
    private String name;

    @NotBlank(message = "slug는 필수입니다.")
    private String slug;

    private String content;

    @Positive(message = "가격은 0 보다 커야합니다.")
    private int price;

    @Min(value = 0, message = "재고는 0 이상이어야 합니다.")
    private int stock;

    @Min(value = 0, message = "배송비는 0 이상이어야 합니다.")
    private int shoppingFee;

    @NotNull(message = "카테고리는 필수입니다.")
    private Long categoryId;

    @Valid
    private List<ProductImageRequest> images;
}

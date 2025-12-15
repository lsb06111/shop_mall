package com.example.shop_api.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CategoryCreateRequest {

    @NotBlank(message = "카테고리명은 필수입니다.")
    private String name;

    @NotBlank(message = "카테고리 slug는 필수입니다.")
    private String slug;

    private Long parentId;

}

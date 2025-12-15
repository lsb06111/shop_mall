package com.example.shop_api.dto.category;

import com.example.shop_api.domain.product.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class CategoryResponse {

    private Long id;
    private String name;
    private String slug;
    private int depth;

    private Long parentId;

    public static CategoryResponse from(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .slug(category.getSlug())
                .depth(category.getDepth())
                .parentId(category.getParent() == null ? null : category.getParent().getId())
                .build();
    }
}

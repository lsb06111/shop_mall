package com.example.shop_api.service;

import com.example.shop_api.domain.product.Category;
import com.example.shop_api.dto.category.CategoryCreateRequest;
import com.example.shop_api.dto.category.CategoryResponse;
import com.example.shop_api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryResponse::from).toList();
    }

    public Long addCategory(CategoryCreateRequest request){
        Category parent = null;
        int depth = 0;

        if(request.getParentId() != null){
            parent = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new IllegalArgumentException("부모 카테고리 없음"));
            depth = parent.getDepth() + 1;
        }

        Category category = Category.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .parent(parent)
                .depth(depth)
                .build();

        return categoryRepository.save(category).getId();
    }
}

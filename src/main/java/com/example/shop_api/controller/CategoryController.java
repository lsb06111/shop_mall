package com.example.shop_api.controller;

import com.example.shop_api.domain.product.Category;
import com.example.shop_api.dto.category.CategoryCreateRequest;
import com.example.shop_api.dto.category.CategoryResponse;
import com.example.shop_api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("listAll")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryCreateRequest request){
        Long id = categoryService.addCategory(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("id",id));
    }
}

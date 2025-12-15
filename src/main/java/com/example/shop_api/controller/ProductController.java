package com.example.shop_api.controller;

import com.example.shop_api.dto.product.ProductCreateRequest;
import com.example.shop_api.dto.product.ProductResponse;
import com.example.shop_api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("listAll")
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("add")
    public ResponseEntity<?> addProduct(@RequestBody ProductCreateRequest request){
        Long id = productService.addProduct(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("id", id));
    }

//    @GetMapping("addImages")
//    @ResponseBody
//    public ResponseEntity<?> addImage(){
//        return new ResponseEntity<>()
//    }
}

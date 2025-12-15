package com.example.shop_api.service;

import com.example.shop_api.domain.product.Category;
import com.example.shop_api.domain.product.Product;
import com.example.shop_api.domain.product.ProductImage;
import com.example.shop_api.dto.product.ProductCreateRequest;
import com.example.shop_api.dto.product.ProductImageResponse;
import com.example.shop_api.dto.product.ProductResponse;
import com.example.shop_api.repository.CategoryRepository;
import com.example.shop_api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductResponse::from).toList();
    }

    public Long addProduct(ProductCreateRequest request){

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("카테고리 없음"));

        Product product = Product.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .content(request.getContent())
                .price(request.getPrice())
                .stock(request.getStock())
                .shoppingFee(request.getShoppingFee())
                .category(category)
                .build();

        if(request.getImages() != null){
            request.getImages().forEach(img ->
                    product.addImage(ProductImage.builder()
                            .slug(img.getSlug())
                            .altText(img.getAltText())
                            .sortOrder(img.getSortOrder())
                            .build()
                    )
            );
        }

        return productRepository.save(product).getId();
    }
}

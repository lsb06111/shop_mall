package com.example.shop_api.domain.product;

import com.example.shop_api.domain.status.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String slug;

    private String content;

    @Column(nullable = false)
    private int price;

    @Builder.Default
    @Column(nullable = false)
    private int stock = 0;

    @Column(nullable = false)
    private int shoppingFee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ProductStatus productStatus = ProductStatus.ORDER_CONFIRMING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ProductImage> productImages = new ArrayList<>();

    public void addImage(ProductImage image){
        productImages.add(image);
        image.setProduct(this);
    }
}

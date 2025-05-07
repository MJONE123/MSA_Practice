package com.example.product_service.controller;

import com.example.product_service.domain.entity.Product;
import com.example.product_service.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
@Tag(name = "Product Controller", description = "제품 관련 API를 제공합니다.")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @Operation(summary = "제품 전체 조회", description = "등록된 모든 제품 정보를 조회합니다.")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @PostMapping
    @Operation(summary = "신규 제품 등록", description = "신규 제품 정보를 등록합니다.")
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }
}

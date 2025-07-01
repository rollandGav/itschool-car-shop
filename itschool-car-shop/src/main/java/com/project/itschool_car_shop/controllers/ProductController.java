package com.project.itschool_car_shop.controllers;

import com.project.itschool_car_shop.models.dtos.ProductDTO;
import com.project.itschool_car_shop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

}

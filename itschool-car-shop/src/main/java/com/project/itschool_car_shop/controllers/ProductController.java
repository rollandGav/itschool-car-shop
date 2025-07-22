package com.project.itschool_car_shop.controllers;

import com.project.itschool_car_shop.models.dtos.ProductDTO;
import com.project.itschool_car_shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDTO>> findProductByBrandAndColourAndCapacityAndPrice
                                            (
                                            @RequestParam String brand,
                                            @RequestParam String colour,
                                            @RequestParam Integer capacity,
                                            @RequestParam Double price
                                            ){
        return ResponseEntity.ok(productService.findProductByBrandAndColourAndCapacityAndPrice(brand, colour, capacity, price));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id){
        productService.deleteProductById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) {
        ProductDTO saved = productService.saveProduct(dto);
        return ResponseEntity.ok(saved);
    }

}

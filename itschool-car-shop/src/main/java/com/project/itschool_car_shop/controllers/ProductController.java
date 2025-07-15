package com.project.itschool_car_shop.controllers;

import com.project.itschool_car_shop.models.dtos.ProductDTO;
import com.project.itschool_car_shop.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/view")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products";
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

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id){
        productService.deleteProductById(id);
    }

}

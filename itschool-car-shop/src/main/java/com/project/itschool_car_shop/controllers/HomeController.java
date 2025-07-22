package com.project.itschool_car_shop.controllers;

import com.project.itschool_car_shop.models.dtos.CustomerDTO;
import com.project.itschool_car_shop.models.dtos.ProductDTO;
import com.project.itschool_car_shop.services.CustomerService;
import com.project.itschool_car_shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;
    private final CustomerService customerService;

    @Autowired
    public HomeController(ProductService productService, CustomerService customerService) {
        this.productService = productService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<ProductDTO> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "products"; // templates/products.html
    }

    @GetMapping("/customers")
    public String viewCustomers(Model model) {
        List<CustomerDTO> customers = customerService.findAllCustomers();
        model.addAttribute("customers", customers);
        return "customers"; // templates/customers.html
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/products/new")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "product-form"; // templates/product-form.html
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String createProduct(@ModelAttribute ProductDTO productDTO) {
        productService.saveProduct(productDTO);
        return "redirect:/products";
    }
}

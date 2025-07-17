package com.project.itschool_car_shop.controllers;

import com.project.itschool_car_shop.models.dtos.CustomerDTO;
import com.project.itschool_car_shop.services.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Customers", description = "Manage customer operations")
@Validated
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Create a new customer")
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer (@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @GetMapping("/jpa-method")
    public ResponseEntity<List<CustomerDTO>> findCustomersJpa(@RequestParam String name, @RequestParam String email){
        return ResponseEntity.ok(customerService.findCustomers(name,email));
    }

    @GetMapping("/query-method")
    public ResponseEntity<List<CustomerDTO>> findCustomersQuery(@RequestParam String name, @RequestParam String email){
        return ResponseEntity.ok(customerService.findCustomersByQuery(name, email));
    }

}

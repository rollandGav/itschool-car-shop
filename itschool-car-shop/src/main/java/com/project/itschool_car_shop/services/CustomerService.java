package com.project.itschool_car_shop.services;

import com.project.itschool_car_shop.models.dtos.CustomerDTO;
import com.project.itschool_car_shop.models.dtos.ProductDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> findCustomers(String name, String email);
    List<CustomerDTO> findCustomersByQuery(String name, String email);

    List<CustomerDTO> findAllCustomers();
}

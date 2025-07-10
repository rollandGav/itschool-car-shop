package com.project.itschool_car_shop.services;

import com.project.itschool_car_shop.models.dtos.ProductDTO;

import java.util.List;

public interface OrderProductService {
    List<ProductDTO> getProductsByOrderId(Long orderId);
    List<ProductDTO> getProductsByCustomerId(Long customerId);
}
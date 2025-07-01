package com.project.itschool_car_shop.services;

import com.project.itschool_car_shop.models.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts();

}

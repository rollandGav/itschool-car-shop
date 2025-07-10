package com.project.itschool_car_shop.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.itschool_car_shop.models.dtos.ProductDTO;
import com.project.itschool_car_shop.models.entities.Product;
import com.project.itschool_car_shop.repositories.OrderProductRepository;
import com.project.itschool_car_shop.services.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository, ObjectMapper objectMapper) {
        this.orderProductRepository = orderProductRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ProductDTO> getProductsByOrderId(Long orderId) {
        List<Product> products = orderProductRepository.findProductsByOrderId(orderId);
        return products.stream()
                .map(product -> objectMapper.convertValue(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCustomerId(Long customerId) {
        List<Product> products = orderProductRepository.findProductsByCustomerId(customerId);
        return products.stream()
                .map(product -> objectMapper.convertValue(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}

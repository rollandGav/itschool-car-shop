package com.project.itschool_car_shop.services.implementations;

import com.project.itschool_car_shop.models.dtos.ProductDTO;
import com.project.itschool_car_shop.models.entities.Product;
import com.project.itschool_car_shop.repositories.ProductRepository;
import com.project.itschool_car_shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        repository.findAll().forEach(product -> fromEntityToDto(productDTOS,product));
        return productDTOS;
    }

    private void fromEntityToDto(List<ProductDTO> productDTOS, Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setBrand(product.getBrand());
        productDTO.setModel(product.getModel());
        productDTO.setColour(product.getColour());
        productDTO.setCapacity(product.getCapacity());
        productDTO.setPrice(product.getPrice());
        productDTO.setYearOfManufacture(product.getYearOfManufacture());
        productDTOS.add(productDTO);
    }
}

package com.project.itschool_car_shop.repositories;

import com.project.itschool_car_shop.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product>  findProductByBrandAndColourAndCapacityAndPrice(String brand, String colour, int capacity, double price);
}

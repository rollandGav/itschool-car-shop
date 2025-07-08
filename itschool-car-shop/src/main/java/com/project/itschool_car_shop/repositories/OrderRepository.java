package com.project.itschool_car_shop.repositories;

import com.project.itschool_car_shop.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}

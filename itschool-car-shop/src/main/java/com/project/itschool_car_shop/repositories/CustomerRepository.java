package com.project.itschool_car_shop.repositories;

import com.project.itschool_car_shop.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

package com.project.itschool_car_shop.repositories;

import com.project.itschool_car_shop.models.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}

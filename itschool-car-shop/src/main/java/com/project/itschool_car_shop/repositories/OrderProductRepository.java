package com.project.itschool_car_shop.repositories;

import com.project.itschool_car_shop.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.* FROM products p " +
            "JOIN order_products op ON p.id = op.product_id " +
            "WHERE op.order_id = :orderId", nativeQuery = true)
    List<Product> findProductsByOrderId(@Param("orderId") Long orderId);

    @Query(value = "SELECT p.* FROM products p " +
            "JOIN order_products op ON p.id = op.product_id " +
            "JOIN orders o ON op.order_id = o.id " +
            "JOIN customers c ON o.customer_id = c.id " +
            "WHERE c.id = :customerId", nativeQuery = true)
    List<Product> findProductsByCustomerId(@Param("customerId") Long customerId);
}

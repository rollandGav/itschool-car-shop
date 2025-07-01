package com.project.itschool_car_shop.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "colour")
    private String colour;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "price")
    private Double price;
    @Column(name = "year_of_manufacture")
    private Date yearOfManufacture;

}

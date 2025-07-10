package com.project.itschool_car_shop.models.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Data
public class AddressDto implements Serializable {
    private String street;
    private String city;
    private String country;
}


package com.project.itschool_car_shop.models.dtos;

import jakarta.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDTO {

    private Long id;
    @NotBlank (message = "Name must not be blank")
    private String name;
    @NotBlank (message = "email must not be blank")
    private String email;
    private AddressDto address;
}

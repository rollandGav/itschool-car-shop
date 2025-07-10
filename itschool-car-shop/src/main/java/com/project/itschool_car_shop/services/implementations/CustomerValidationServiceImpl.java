package com.project.itschool_car_shop.services.implementations;

import com.project.itschool_car_shop.services.CustomerValidationService;
import org.springframework.stereotype.Service;

@Service
public class CustomerValidationServiceImpl implements CustomerValidationService {
    @Override
    public void emailValidation(String email) {
        if(!email.trim().contains("@") || email.trim().length() < 5){
            throw new RuntimeException("Email is not valid");
        }
    }
}

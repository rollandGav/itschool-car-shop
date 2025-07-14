package com.project.itschool_car_shop.controllers;

import com.project.itschool_car_shop.models.entities.AppUser;
import com.project.itschool_car_shop.repositories.AppUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserController {
    private final AppUserRepository userRepository;

    public AppUserController(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AppUser user) {
        user.setPassword(user.getPassword());
        user.setRole("USER");
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
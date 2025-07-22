package com.project.itschool_car_shop.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.itschool_car_shop.models.dtos.CustomerDTO;
import com.project.itschool_car_shop.models.entities.Customer;
import com.project.itschool_car_shop.repositories.CustomerRepository;
import com.project.itschool_car_shop.services.CustomerService;
import com.project.itschool_car_shop.services.CustomerValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerValidationService customerValidationService;
    private ObjectMapper objectMapper;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerValidationService customerValidationService,
                               ObjectMapper objectMapper,
                               CustomerRepository customerRepository) {
        this.customerValidationService = customerValidationService;
        this.objectMapper = objectMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerValidationService.emailValidation(customerDTO.getEmail());
        Customer customer = objectMapper.convertValue(customerDTO, Customer.class);
        Customer customerDuble =  customerRepository.save(customer);
        return objectMapper.convertValue(customerDuble, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> findCustomers(String name, String email) {
        return customerRepository.findByNameAndEmail(name, email)
                .stream()
                .map(customer -> objectMapper.convertValue(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findCustomersByQuery(String name, String email) {
        return customerRepository.findByNameAndEmail2(name, email)
                .stream()
                .map(customer -> objectMapper.convertValue(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> CustomerDTO.builder()
                        .id(customer.getId())
                        .name(customer.getName())
                        .email(customer.getEmail())
                        .build())
                .toList();
    }
}

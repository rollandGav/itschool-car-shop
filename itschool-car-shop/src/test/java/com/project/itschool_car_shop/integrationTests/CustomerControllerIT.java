package com.project.itschool_car_shop.integrationTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.itschool_car_shop.models.dtos.AddressDto;
import com.project.itschool_car_shop.models.dtos.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateCustomer_ShouldPass() throws Exception {
        AddressDto address = AddressDto.builder()
                .street("Strada Libertatii 12")
                .city("Bucuresti")
                .country("Romania")
                .build();

        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("Marcus")
                .email("marcus@gmail.com")
                .address(address)
                .build();

        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToString(customerDTO)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name").value(customerDTO.getName()));
    }

    @Test
    void shouldCreateCustomerSuccessfully() throws Exception {
        AddressDto address = AddressDto.builder()
                .street("Strada Libertatii 12")
                .city("Bucuresti")
                .country("Romania")
                .build();
        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("Alice")
                .email("alice.smith@example.com")
                .address(address)
                .build();

        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("alice.smith@example.com"));
    }


    private String objectToString ( Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}

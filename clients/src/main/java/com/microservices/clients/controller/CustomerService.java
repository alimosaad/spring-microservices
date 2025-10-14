package com.microservices.clients.controller;

import com.microservices.clients.model.Customer;
import com.microservices.clients.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    /// take customerRepo for use it to connection with db
    private final CustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer=Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo: check if not taken
        // todo: store in database
        customerRepository.save(customer);
    }
}

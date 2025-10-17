package com.microservices.clients.services;

import com.microservices.clients.model.Customer;
import com.microservices.clients.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    /// take customerRepo for use it to connection with db
    private final CustomerRepository customerRepository;
    ///  inject Rest template
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer=Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo: check if not taken

        // todo: store in database
        customerRepository.saveAndFlush(customer);
        // todo: check if fraud
        FraudCheckResponse fraudCheckResponse =restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (fraudCheckResponse.isFraud()){
            throw new IllegalStateException("fraudester");
        }

        // todo: send notification
    }
}

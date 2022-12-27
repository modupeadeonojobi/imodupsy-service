package com.imodupsy.customer.service;

import com.imodupsy.customer.dao.CustomerRepository;
import com.imodupsy.customer.dto.CustomerRegistrationRequest;
import com.imodupsy.customer.dto.FraudCheckResponse;
import com.imodupsy.customer.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author iModupsy
 * @created 25/12/2022
 */
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) throws IllegalAccessException {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class, customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalAccessException("fraudster ");
        }

    }
}

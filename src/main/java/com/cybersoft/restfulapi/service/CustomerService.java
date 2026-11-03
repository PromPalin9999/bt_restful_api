package com.cybersoft.restfulapi.service;


import com.cybersoft.restfulapi.entity.CustomerEntity;
import com.cybersoft.restfulapi.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<CustomerEntity> getAllCus() {
        return customerRepository.getAllCus();
    }

    public CustomerEntity findCusById(Long id) {
        return customerRepository.findCusById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));

    }

}

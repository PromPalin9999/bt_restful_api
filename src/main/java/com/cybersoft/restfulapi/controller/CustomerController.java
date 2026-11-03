package com.cybersoft.restfulapi.controller;


import com.cybersoft.restfulapi.entity.CustomerEntity;
import com.cybersoft.restfulapi.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<List<CustomerEntity>> getAllCus() {
        return ResponseEntity.ok(customerService.getAllCus());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCusById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCusById(id));
    }
}

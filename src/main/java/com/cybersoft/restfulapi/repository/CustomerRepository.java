package com.cybersoft.restfulapi.repository;

import com.cybersoft.restfulapi.entity.CustomerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class CustomerRepository {

    private final Map<Long, CustomerEntity> customsMock = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong();

    public CustomerRepository() {
        add(newCustomer("Yamal .M", "0934234234"));
        add(newCustomer("Michel .R", "0934234234"));
        add(newCustomer("Luzer .B", "0934234234"));

    }

    public CustomerEntity newCustomer(String name, String phone) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setPhone(phone);
        return customer;
    }

    ;

    public CustomerEntity add(CustomerEntity customer) {
        customer.setId(idGen.incrementAndGet());
        customsMock.put(customer.getId(), customer);
        return customer;
    }

    public List<CustomerEntity> getAllCus() {
        return new ArrayList<>(customsMock.values());
    }

    public Optional<CustomerEntity> findCusById(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        return Optional.ofNullable(customsMock.get(id));
    }

}

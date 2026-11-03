package com.cybersoft.restfulapi.service;


import com.cybersoft.restfulapi.entity.OrderEntity;
import com.cybersoft.restfulapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> findAllOrd() {
        return orderRepository.findAllOrd();
    }


    public OrderEntity createOrd(OrderEntity order) {
        return orderRepository.add(order);
    }


}

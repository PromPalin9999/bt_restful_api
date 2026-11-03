package com.cybersoft.restfulapi.controller;


import com.cybersoft.restfulapi.entity.OrderEntity;
import com.cybersoft.restfulapi.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrd() {
        return ResponseEntity.ok(orderService.findAllOrd());

    }


    @PostMapping
    public ResponseEntity<OrderEntity> createOrd(@RequestBody OrderEntity order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrd(order));
    }

}

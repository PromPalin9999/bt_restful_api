package com.cybersoft.restfulapi.repository;


import com.cybersoft.restfulapi.entity.OrderEntity;
import com.cybersoft.restfulapi.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {
    private final Map<Long, OrderEntity> orders = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong();
    private final AtomicLong idGenP = new AtomicLong();

    public OrderRepository() {
        add(newOrd("Lewan .D",
                newPrd("Mechanical Keyboard", 1200000.0),
                newPrd("Gaming Mouse", 650000.0),
                newPrd("Mouse Pad XL", 150000.0),
                newPrd("USB Hub 4 Ports", 220000.0),
                newPrd("Webcam 1080p", 800000.0)));

        add(newOrd("Kelvin .M",
                newPrd("Wireless Mouse", 350000.0),
                newPrd("Laptop Stand", 420000.0),
                newPrd("HDMI Cable 2m", 90000.0)));

        add(newOrd("Jacky .H",
                newPrd("CPU Ryzen 5 5600", 2800000.0),
                newPrd("Motherboard B550", 2500000.0),
                newPrd("RAM 16GB DDR4", 900000.0),
                newPrd("SSD NVMe 512GB", 1100000.0)));

        add(newOrd("Luis .R",
                newPrd("RAM 32GB DDR4", 1800000.0),
                newPrd("Graphics Card RTX 4060", 8500000.0),
                newPrd("Power Supply 650W", 1500000.0),
                newPrd("PC Case Mid Tower", 1300000.0),
                newPrd("CPU Cooler", 600000.0)));

        add(newOrd("Reny .K",
                newPrd("Monitor 24 inch", 3200000.0),
                newPrd("Headset 7.1", 950000.0),
                newPrd("Microphone USB", 780000.0)));

        add(newOrd("Emma .T",
                newPrd("Office Chair", 2400000.0),
                newPrd("Desk Lamp", 280000.0),
                newPrd("Keyboard Wrist Rest", 120000.0),
                newPrd("Cable Organizer", 60000.0)));

        add(newOrd("Noah .P",
                newPrd("External HDD 1TB", 1050000.0),
                newPrd("Flash Drive 64GB", 150000.0),
                newPrd("Card Reader", 80000.0)));
    }

    public ProductEntity newPrd(String name, Double price) {
        ProductEntity prd = new ProductEntity();
        prd.setName(name);
        prd.setPrice(price);
        return prd;
    }

    public OrderEntity newOrd(String customerName, ProductEntity... prds) {
        OrderEntity ord = new OrderEntity();
        ord.setCustomerName(customerName);
        ord.setProducts(new ArrayList<>(Arrays.asList(prds)));
        return ord;
    }

    public OrderEntity add(OrderEntity o) {
        o.setId(idGen.incrementAndGet());
        for (ProductEntity p : o.getProducts()) {
            p.setId(idGenP.incrementAndGet());
        }
        orders.put(o.getId(), o);
        return o;
    }

    public List<OrderEntity> findAllOrd() {
        return orders.values().stream().sorted(Comparator.comparing(OrderEntity::getId)).toList();
    }
}

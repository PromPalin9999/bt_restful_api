package com.cybersoft.restfulapi.service;

import com.cybersoft.restfulapi.dto.request.ProductRequestDTO;
import com.cybersoft.restfulapi.dto.response.ProductResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final Map<Long, ProductResponseDTO> storeP = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong();


    public ProductService() {
        add("Ghế gaming", 1500000.0);
        add("Bàn phím k70", 80000.0);
    }

    private void add(String prdName, Double price) {
        ProductResponseDTO p = new ProductResponseDTO();
        p.setId(idGen.incrementAndGet());
        p.setPrdName(prdName);
        p.setPrice(price);
        p.setCreatedAt(LocalDateTime.now().toString());
        storeP.put(p.getId(), p);
    }

    public List<ProductResponseDTO> getPrdLst() {
        return new ArrayList<>(storeP.values());
    }

    public ProductResponseDTO findPrdById(Long id) {
        ProductResponseDTO prd = storeP.get(id);
        if (prd == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Do not have product with this id");
        return prd;
    }

    public ProductResponseDTO createPrd(ProductRequestDTO prdReq) {
        ProductResponseDTO prd = new ProductResponseDTO();
        prd.setId(idGen.incrementAndGet());
        prd.setPrdName(prdReq.getPrdName());
        prd.setPrice(prdReq.getPrice());
        prd.setCreatedAt(LocalDateTime.now().toString());
        storeP.put(prd.getId(), prd);
        return prd;
    }

    public ProductResponseDTO updPrd(Long id, ProductRequestDTO prdReq) {
        ProductResponseDTO prd = findPrdById(id);
        if (Objects.equals(prd.getPrdName(), prdReq.getPrdName()) && Objects.equals(prd.getPrice(), prdReq.getPrice())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "have not new info to update");
        }
        prd.setPrdName(prdReq.getPrdName());
        prd.setPrice(prdReq.getPrice());
        return prd;
    }

    public void delPrd(Long id) {
        if (storeP.remove(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found product with id: " + id);
        }
    }


}

package com.cybersoft.restfulapi.controller;


import com.cybersoft.restfulapi.dto.request.ProductRequestDTO;
import com.cybersoft.restfulapi.dto.response.ProductResponseDTO;
import com.cybersoft.restfulapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getPrdLst() {
        List<ProductResponseDTO> prdLst = productService.getPrdLst();
        return ResponseEntity.ok(prdLst);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findPrdById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findPrdById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createPrd(@Valid @RequestBody ProductRequestDTO prdReq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createPrd(prdReq));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updPrd(@PathVariable Long id,
                                                     @Valid @RequestBody ProductRequestDTO prdReq) {
        return ResponseEntity.ok(productService.updPrd(id, prdReq));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> delPrd(@PathVariable Long id) {
        productService.delPrd(id);
        return ResponseEntity.noContent().build();
    }
}

package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.services.product.ProductService;
import com.sda.java3.ecommerce.services.product.SaveProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @GetMapping("/id")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
//        var item = this.productService.getProductById(id.toString());

        return new ResponseEntity<>(productService.getProductById(id.toString()), HttpStatus.OK);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping
    public UUID save(@RequestBody @Valid SaveProductRequest request) {
        return productService.save(request);
    }}


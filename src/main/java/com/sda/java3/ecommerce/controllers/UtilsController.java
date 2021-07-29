package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.services.product.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/utils")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UtilsController {
    protected @NonNull ProductService propertyService;

    @ResponseBody
    @RequestMapping(value = "/create-initial-data")
    public ResponseEntity<String> createInitialData() {
        propertyService.createDummyProducts();
        return ResponseEntity.ok("Data created successfully!");
    }
}

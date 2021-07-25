package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.services.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String home() {
        return "product-list";
    }

    @GetMapping("/product-detail")
    public String productDetail() {
        return "product-detail";
    }
}

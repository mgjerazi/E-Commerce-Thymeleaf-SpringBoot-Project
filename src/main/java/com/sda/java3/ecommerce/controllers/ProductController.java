package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.services.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    protected final ProductService productService;

    public ProductController(final ProductService productRepository) {
        this.productService = productRepository;
    }

    @GetMapping("/products")
    public String home() {
        return "product-list";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable String id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.getProductById(id));
        return "product-detail";
    }
}

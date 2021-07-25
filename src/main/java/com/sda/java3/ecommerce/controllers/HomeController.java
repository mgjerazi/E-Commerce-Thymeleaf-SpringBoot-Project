package com.sda.java3.ecommerce.controllers;


import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.services.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    protected final ProductService productService;

    public HomeController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(ModelMap map) {
        List<Product> featuredProducts = productService.getFeaturedProducts();
        map.addAttribute("page", "home");
        map.addAttribute("featuredProducts", featuredProducts);
        return "home";
    }
}


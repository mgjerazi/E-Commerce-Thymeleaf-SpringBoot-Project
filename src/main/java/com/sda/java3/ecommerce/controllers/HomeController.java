package com.sda.java3.ecommerce.controllers;


import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.services.category.CategoryService;
import com.sda.java3.ecommerce.services.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController extends BaseController {
    public HomeController(ProductService productService, CategoryService categoryService) {
        super(productService, categoryService);
    }

    @GetMapping("/")
    public String home(ModelMap map) {
        initModelMap(map);

        List<Product> featuredProducts = productService.getFeaturedProducts();
        map.addAttribute("page", "home");
        map.addAttribute("featuredProducts", featuredProducts);
        map.addAttribute("recentProducts", productService.getRecentProducts());

        map.addAttribute("productList", productService.findAll());
        return "home";
    }
}


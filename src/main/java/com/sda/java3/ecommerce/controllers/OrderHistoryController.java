package com.sda.java3.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderHistoryController {
    @GetMapping("/order-history")
    public String home() {
        return "order-history";
    }
}


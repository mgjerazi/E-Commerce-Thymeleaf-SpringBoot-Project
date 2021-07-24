package com.sda.java3.ecommerce.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(ModelMap map) {
        map.addAttribute("page", "home");
        return "home";
    }
}


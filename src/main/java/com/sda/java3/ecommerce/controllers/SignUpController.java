package com.sda.java3.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {
    @GetMapping("/sign-up")
    public String home() {
        return "sign-up";
    }
}

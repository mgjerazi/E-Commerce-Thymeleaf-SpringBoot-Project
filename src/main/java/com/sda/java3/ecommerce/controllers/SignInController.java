package com.sda.java3.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SignInController {
    @GetMapping("/sign-in")
    public String home() {
        return "sign-in";
    }
}

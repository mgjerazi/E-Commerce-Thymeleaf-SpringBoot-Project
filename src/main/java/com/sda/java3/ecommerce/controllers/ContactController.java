package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.services.category.CategoryService;
import com.sda.java3.ecommerce.services.product.ProductService;
import com.sda.java3.ecommerce.utils.Breadcrumb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class ContactController extends BaseController {
    public ContactController(ProductService productService, CategoryService categoryService) {
        super(productService, categoryService);
    }

    @GetMapping("/contact")
    public String home(ModelMap modelMap) {
        initModelMap(modelMap);

        modelMap.addAttribute("breadcrumbs", Arrays.asList(
                Breadcrumb.builder().name("Home").url("/").build(),
                Breadcrumb.builder().name("Contact").url("/contact").last(true).build()
        ));
        return "contact";
    }
}

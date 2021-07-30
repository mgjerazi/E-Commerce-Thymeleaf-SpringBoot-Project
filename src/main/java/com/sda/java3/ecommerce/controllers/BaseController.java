package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.services.category.CategoryService;
import com.sda.java3.ecommerce.services.product.ProductService;
import com.sda.java3.ecommerce.utils.ProductListFilter;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class BaseController {
    protected final ProductService productService;
    protected final CategoryService categoryService;

    public BaseController(final ProductService productService, final CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    public void initModelMap(ModelMap map) {
        map.addAttribute("rootCategories", categoryService.getRootCategories());
        map.addAttribute("filter", new ProductListFilter());
    }
}

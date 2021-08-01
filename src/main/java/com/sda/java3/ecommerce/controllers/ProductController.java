package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.services.category.CategoryService;
import com.sda.java3.ecommerce.services.product.ProductService;
import com.sda.java3.ecommerce.utils.Breadcrumb;
import com.sda.java3.ecommerce.utils.ProductListFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class ProductController extends BaseController {

    public ProductController(ProductService productService, CategoryService categoryService) {
        super(productService, categoryService);
    }

    @GetMapping("/products")
    public String getProducts(ModelMap modelMap, ProductListFilter filter) {
        initModelMap(modelMap);
        return filterProducts(filter, modelMap);
    }

    @PostMapping("/products")
    public String filterProducts(@ModelAttribute ProductListFilter filter, ModelMap model) {
        initModelMap(model);
        model.addAttribute("breadcrumbs", Arrays.asList(
                Breadcrumb.builder().name("Home").url("/").last(true).build()
        ));
        model.addAttribute("products", productService.getProducts(filter));
        model.addAttribute("filter", filter);
        model.addAttribute("categories", categoryService.getCategories());
        return "product-list";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable String id, ModelMap modelMap) {
        initModelMap(modelMap);
        Product product = productService.getProductById(id);
        modelMap.addAttribute("breadcrumbs", Arrays.asList(
                Breadcrumb.builder().name("Home").url("/").build(),
                Breadcrumb.builder().name(product != null ? product.getName() : "").last(true).url(String.format("/product-detail/%s", id)).build()

        ));
        modelMap.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/product-list-detail/{id}")
    public String productListDetail(@PathVariable String id, ModelMap modelMap) {
        initModelMap(modelMap);
        Product product = productService.getProductById(id);
        modelMap.addAttribute("breadcrumbs", Arrays.asList(
                Breadcrumb.builder().name("Home").url("/").build(),
                Breadcrumb.builder().name("Products").url("/products").build(),
                Breadcrumb.builder().name(product != null ? product.getName() : "").last(true).url(String.format("/product-detail/%s", id)).build()

        ));
        modelMap.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/products/category/{id}")
    public String filterByCategory(@PathVariable String id, ModelMap modelMap) {
        initModelMap(modelMap);
        ProductListFilter filter = new ProductListFilter();
        filter.setCategoryId(id);
        return filterProducts(filter, modelMap);
    }
}
//    @GetMapping("/products")
//    public String home(ModelMap modelMap, String keyword) {
//        if (keyword != null){
//            modelMap.addAttribute("products", productService.findByKeyword(keyword));
//        } else {
//            modelMap.addAttribute("productList", productService.findAll());
//        }
//
//        return "product-list";
//
//    }

package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.domains.Category;
import com.sda.java3.ecommerce.services.category.CategoryService;
import com.sda.java3.ecommerce.services.category.SaveCategoryRequest;
import com.sda.java3.ecommerce.services.product.SaveProductRequest;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryApiController {
    private final CategoryService categoryService;

//    @GetMapping("/id")
//    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
////        var item = this.productService.getProductById(id.toString());
//
////        return new ResponseEntity<>(categoryService.getCategories(id.toString()), HttpStatus.OK);
////    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping
    public UUID save(@RequestBody @Valid SaveCategoryRequest request) {
        return categoryService.save(request);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable UUID id) {
        categoryService.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> get(@PathVariable UUID id) {
        var item = this.categoryService.findById(id);
        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}


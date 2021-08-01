package com.sda.java3.ecommerce.services.category;

import com.sda.java3.ecommerce.domains.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> getRootCategories();
    List<Category> getCategories();
    List<Category> findAll();
    void delete(UUID id);
    UUID save(SaveCategoryRequest request);
    Optional<Category> findById(UUID id);
}

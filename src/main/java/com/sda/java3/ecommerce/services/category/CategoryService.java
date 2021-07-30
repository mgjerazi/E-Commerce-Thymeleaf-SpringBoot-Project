package com.sda.java3.ecommerce.services.category;

import com.sda.java3.ecommerce.domains.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getRootCategories();
    List<Category> getCategories();
}

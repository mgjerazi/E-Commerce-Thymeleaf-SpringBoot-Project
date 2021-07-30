package com.sda.java3.ecommerce.services.category;

import com.sda.java3.ecommerce.domains.Category;
import com.sda.java3.ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    protected final CategoryRepository categoryRepository;

    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getRootCategories() {
        return categoryRepository.getRootCategories();
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}

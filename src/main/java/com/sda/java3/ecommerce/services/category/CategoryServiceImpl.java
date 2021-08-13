package com.sda.java3.ecommerce.services.category;

import com.sda.java3.ecommerce.domains.Category;
import com.sda.java3.ecommerce.repositories.CategoryRepository;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        var item = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        categoryRepository.delete(item);
    }

    @Override
    public UUID save(SaveCategoryRequest request) {
        var dbItem = categoryRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setName(request.getName());
            categoryRepository.save(dbItem.get());
            return dbItem.get().getId();
        }
        var newItem = Category.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .build();
        categoryRepository.save(newItem);
        return newItem.getId();
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return categoryRepository.findById(id);
    }

}

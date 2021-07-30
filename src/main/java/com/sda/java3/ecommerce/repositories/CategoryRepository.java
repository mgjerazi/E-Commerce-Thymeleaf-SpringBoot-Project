package com.sda.java3.ecommerce.repositories;

import com.sda.java3.ecommerce.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Query(value = "SELECT p FROM Category p where p.parentId is null")
    List<Category> getRootCategories();
}

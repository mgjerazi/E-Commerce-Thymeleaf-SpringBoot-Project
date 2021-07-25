package com.sda.java3.ecommerce.repositories;

import com.sda.java3.ecommerce.domains.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}

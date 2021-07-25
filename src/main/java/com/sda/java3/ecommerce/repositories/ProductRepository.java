package com.sda.java3.ecommerce.repositories;

import com.sda.java3.ecommerce.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}

package com.sda.java3.ecommerce.repositories;

import com.sda.java3.ecommerce.domains.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query(value = "SELECT p FROM Product p where p.featured = 1")
    List<Product> getFeaturedProducts();

    @Query(nativeQuery = true, value = "SELECT * FROM ec_product p ORDER BY p.created_at DESC LIMIT 8")
    List<Product> getRecentProducts();
}

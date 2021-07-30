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

    @Query(value = "select p from Product p where (:categoryId is null or cast(p.categoryId as string)= :categoryId) " +
            "and ((:query is null or lower(p.name)  like concat('%', lower(:query), '%')) or (:query is null or lower(p.description)  like concat('%', lower(:query), '%')) ) " +
            "order by p.createdAt desc "
    )
    List<Product> getList(
            @Param("categoryId") String categoryId,
            @Param("query") String query
    );

}

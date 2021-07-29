package com.sda.java3.ecommerce.services.product;

import com.sda.java3.ecommerce.domains.Product;

import java.util.List;

public interface ProductService {
    List<Product> getFeaturedProducts();
    List<Product> getRecentProducts();
    void createDummyProducts();
    Product getProductById(String id);
}

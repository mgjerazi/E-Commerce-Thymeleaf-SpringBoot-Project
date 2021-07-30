package com.sda.java3.ecommerce.services.product;

import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.utils.ProductListFilter;

import java.util.List;

public interface ProductService {
    List<Product> getFeaturedProducts();
    List<Product> getRecentProducts();
    List<Product> getProducts(ProductListFilter filter);
    void createDummyProducts();
    Product getProductById(String id);
    List<Product> findAll();
}

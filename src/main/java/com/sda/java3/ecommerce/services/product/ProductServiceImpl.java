package com.sda.java3.ecommerce.services.product;

import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(final ProductRepository clientRepository) {
        this.productRepository= clientRepository;
    }


    @Override
    public List<Product> getFeaturedProducts() {
        return productRepository.findAll();
    }
}

package com.sda.java3.ecommerce.services.product;

import com.sda.java3.ecommerce.domains.Category;
import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.repositories.CategoryRepository;
import com.sda.java3.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(final ProductRepository clientRepository, final CategoryRepository categoryRepository) {
        this.productRepository= clientRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Product> getFeaturedProducts() {
        return productRepository.getFeaturedProducts();
    }

    @Override
    public void createDummyProducts() {
        Category category = Category.builder()
                .name("Men")
                .build();
        categoryRepository.save(category);


        Product product = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(category.getId())
                .name("Product 1")
                .description("This is the description of product 1")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .featured(true)
                .featureImage("featured_image_1.jpg")
                .build();

        productRepository.save(product);
    }
}

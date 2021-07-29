package com.sda.java3.ecommerce.services.product;

import com.sda.java3.ecommerce.domains.Category;
import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.repositories.CategoryRepository;
import com.sda.java3.ecommerce.repositories.ProductRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    public List<Product> getRecentProducts() {
        return productRepository.getRecentProducts();
    }

    @Override
    public Product getProductById(String id) {
        try {
            return productRepository.getById(UUID.fromString(id));
        } catch (DataAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void createDummyProducts() {
        Category menCategory = Category.builder()
                .name("Men")
                .build();
        categoryRepository.save(menCategory);

        Category womenCategory = Category.builder()
                .name("Women")
                .build();
        categoryRepository.save(womenCategory);


        Product product = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .featured(true)
                .featureImage("featured_image_1.jpg")
                .build();
        productRepository.save(product);

        Product womanProduct = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .image("image2.jpg")
                .sale(false)
                .featured(true)
                .featureImage("featured_image_2.jpg")
                .build();

        productRepository.save(womanProduct);
    }
}

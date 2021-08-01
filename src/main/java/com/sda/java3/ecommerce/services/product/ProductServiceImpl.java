package com.sda.java3.ecommerce.services.product;

import com.sda.java3.ecommerce.domains.Category;
import com.sda.java3.ecommerce.domains.Product;
import com.sda.java3.ecommerce.repositories.CategoryRepository;
import com.sda.java3.ecommerce.repositories.ProductRepository;
import com.sda.java3.ecommerce.utils.ProductListFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(final ProductRepository clientRepository, final CategoryRepository categoryRepository) {
        this.productRepository = clientRepository;
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
    public List<Product> getProducts(ProductListFilter filter) {
        if (filter != null && filter.getCategoryId() != null && !filter.getCategoryId().isEmpty()) {
            Category category = categoryRepository.getById(UUID.fromString(filter.getCategoryId()));
            if (category != null)
                filter.setCategoryName(category.getName());
        }

        return productRepository.getList(
                StringUtils.isNotBlank(filter.getCategoryId()) ? filter.getCategoryId() : null,
                StringUtils.isNotBlank(filter.getQuery()) ? filter.getQuery() : null
        );
    }

    @Override
    public Product getProductById(String id) {
        try {
            Product product = productRepository.getById(UUID.fromString(id));
            product.setViews(product.getViews() + 1);
            productRepository.save(product);
            return product;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public UUID save(SaveProductRequest request) {
        return null;
    }


    @Override
    public void createDummyProducts() {
        Category menCategory = Category.builder()
                .name("MEN")
                .build();
        categoryRepository.save(menCategory);

        Category womenCategory = Category.builder()
                .name("WOMEN")
                .build();
        categoryRepository.save(womenCategory);


        Product womanProduct = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(true)
                .featureImage("featured_image_2.jpg")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct);

        Product womanProduct1 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(true)
                .featureImage("featured_image_2.jpg")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct1);

        Product womanProduct2 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct2);

        Product womanProduct3 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct3);

        Product womanProduct4 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct4);

        Product womanProduct5 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct5);
        Product womanProduct6 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct6);
        Product womanProduct7 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct7);
        Product womanProduct8 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct8);
        Product womanProduct9 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(womanProduct9);

        Product womanProduct10 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(womanProduct10);

        Product womanProduct11 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct11);
        Product womanProduct12 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct12);
        Product womanProduct13 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct13);
        Product womanProduct14 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct14);
        Product womanProduct15 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct15);
        Product womanProduct16 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct16);
        Product womanProduct17 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct17);
        Product womanProduct18 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct18);

        Product womanProduct19 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Armani Dress")
                .description("This is the description of Armani Dress")
                .price(500)
                .views(2)
                .image("image2.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct19);

        productRepository.save(womanProduct13);
        Product menProduct21 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Black Happy Embroidered Oversized Tshirt ")
                .description("Black Happy Embroidered Oversized Tshirt ")
                .price(20)
                .views(2)
                .image("men/black-happy-embroidered-oversized-t-shirt.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(menProduct21);


        Product menProduct = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Black Ripped Knee Crop Slim Leg Jeans ")
                .description("This is the description of Versace T-Shirt")
                .price(25)
                .image("men/black-ripped-knee-crop-slim-leg-jeans.jpg")
                .sale(false)
                .views(2)
                .featured(true)
                .featureImage("featured_image_1.jpg")
                .size("S,M,L,Xl,XXL").size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct);

        Product menProduct2 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Black Tropical Short Sleeve Shirt ")
                .description("")
                .price(20)
                .image("men/black-tropical-short-sleeve-shirt.jpg")
                .sale(false)
                .views(2)
                .featured(true)
                .featureImage("featured_image_1.jpg")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct2);
        Product menProduct3 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Blue Dark Wash Baggy Fit Jeans ")
                .description("This is the description of Versace T-Shirt")
                .price(30)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct3);
        Product menProduct4 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Blue Miami Embroidered Colour Block Tshirt ")
                .description("This is the description of Versace T-Shirt")
                .price(25)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct4);
        Product menProduct6 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Blue Mid Wash Baggy Fit Jeans ")
                .description("This is the description of Versace T-Shirt")
                .price(25)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct6);
        Product menProduct7 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct7);
        Product menProduct8 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct8);
        Product menProduct9 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct9);
        Product menProduct10 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct10);
        Product menProduct11 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct11);
        Product menProduct12 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct12);
        Product menProduct13 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct13);
        Product menProduct14 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct14);
        Product menProduct15 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct15);
        Product menProduct16 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct16);
        Product menProduct17 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct17);
        Product menProduct18 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct18);
        Product menProduct19 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct19);
        Product menProduct20 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Versace T-shirt")
                .description("This is the description of Versace T-Shirt")
                .price(500)
                .image("image1.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct20);
    }
}

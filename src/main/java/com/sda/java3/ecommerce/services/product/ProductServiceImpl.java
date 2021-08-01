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
                .name("")
                .description("")
                .price(28)
                .views(2)
                .image("")
                .sale(false)
                .featured(true)
                .featureImage("featured_image_2.jpg")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct);

        Product womanProduct1 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("")
                .description("")
                .price(35)
                .views(2)
                .image("")
                .sale(false)
                .featured(true)
                .featureImage("featured_image_2.jpg")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct1);

        Product womanProduct2 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Black Buckle Strap Pinafore Dress")
                .description("Black Buckle Strap Pinafore Dress")
                .price(500)
                .views(2)
                .image("women/black-buckle-strap-pinafore-dress.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct2);

        Product womanProduct3 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Black Leather Look Woven Shopper Bag")
                .description("Black Leather Look Woven Shopper Bag")
                .price(35)
                .views(2)
                .image("women/black-leather-look-woven-shopper-bag.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct3);

        Product womanProduct4 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Black Leather Look Yip Trim Lace Up Chunky Boots")
                .description("Black Leather Look Yip Trim Lace Up Chunky Boots")
                .price(45)
                .views(2)
                .image("women/black-leather-look-zip-trim-lace-up-chunky-boots.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct4);

        Product womanProduct5 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Black Leather Strappy Flat Sandals")
                .description("Black Leather Strappy Flat Sandals")
                .price(22)
                .views(2)
                .image("women/black-leather-strappy-flat-sandals.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct5);
        Product womanProduct6 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Mid Pink Ribbed Twist Open Back Mini Dress")
                .description("Mid Pink Ribbed Twist Open Back Mini Dress")
                .price(40)
                .views(2)
                .image("women/mid-pink-ribbed-twist-open-back-midi-dress-1.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct6);
        Product womanProduct7 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Black Poplin Shirred Bardot Top")
                .description("Black Poplin Shirred Bardot Top")
                .price(25)
                .views(2)
                .image("women/black-poplin-shirred-bardot-top.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct7);
        Product womanProduct8 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Black Rose Lips Lamour Logo T-shirt")
                .description("Black Rose Lips Lamour Logo T-shirt")
                .price(22)
                .views(2)
                .image("women/black-rose-lips-lamour-logo-t-shirt.jpg")
                .sale(false)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();

        productRepository.save(womanProduct8);
        Product womanProduct9 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(womenCategory.getId())
                .name("Black Zip Front Friends Logo Mini Backpack")
                .description("Black Zip Front Friends Logo Mini Backpack")
                .price(32)
                .views(2)
                .image("women/black-zip-front-friends-logo-mini-backpack.jpg")
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
                .name("Black Happy Embroidered Oversized Tshirt")
                .description("Black Happy Embroidered Oversized Tshirt")
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
                .name("Black Ripped Knee Crop Slim Leg Jeans")
                .description("Black Ripped Knee Crop Slim Leg Jeans ")
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
                .name("Black Tropical Short Sleeve Shirt")
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
                .description("Blue Dark Wash Baggy Fit Jeans ")
                .price(30)
                .image("men/blue-dark-wash-baggy-fit-jeans.jpg")
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
                .name("Blue Miami Embroidered Colour Block Tshirt")
                .description("Blue Miami Embroidered Colour Block Tshirt")
                .price(25)
                .image("men/blue-miami-embroidered-colour-block-t-shirt.jpg")
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
                .name("Blue Mid Wash Baggy Fit Jeans")
                .description("Blue Mid Wash Baggy Fit Jeans")
                .price(25)
                .image("men/blue-mid-wash-baggy-fit-jeans.jpg")
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
                .name("Blue Stone Wash Straight Fit Jeans")
                .description("This is the description of Versace T-Shirt")
                .price(40)
                .image("men/blue-stone-wash-straight-fit-jeans (1).jpg")
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
                .name("Jack Jones White Surfing Logo Tshirt ")
                .description("Jack Jones White Surfing Logo Tshirt ")
                .price(45)
                .image("men/jack-jones-white-surfing-logo-t-shirt.jpg")
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
                .name("Navy Pocket Front Zip Up Hoodie ")
                .description("Navy Pocket Front Zip Up Hoodie ")
                .price(32)
                .image("men/navy-pocket-front-zip-up-hoodie.jpg")
                .sale(false)
                .views(2)
                .featured(false)
                .featureImage("")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct9);

        Product menProduct11 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Navy Poplin Long Sleeve Shirt ")
                .description("Navy Poplin Long Sleeve Shirt ")
                .price(28)
                .image("men/navy-poplin-long-sleeve-shirt.jpg")
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
                .name("Navy Regular Fit Crew Tshirt ")
                .description("Navy Regular Fit Crew Tshirt ")
                .price(27)
                .image("men/navy-regular-fit-crew-t-shirt.jpg")
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
                .name("Navy Wave Print Short Sleeve Shirt ")
                .description("Navy Wave Print Short Sleeve Shirt")
                .price(24)
                .image("men/navy-poplin-long-sleeve-shirt.jpg")
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
                .name("Only Sons Black Tropical Short Sleeve Shirt")
                .description("Only Sons Black Tropical Short Sleeve Shirt")
                .price(33)
                .image("men/only-sons-black-tropical-short-sleeve-shirt.jpg")
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
                .name("Pale Blue Light Wash Slim Fit Jeans ")
                .description("Pale Blue Light Wash Slim Fit Jeans ")
                .price(35)
                .image("men/pale-blue-light-wash-slim-fit-jeans.jpg")
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
                .name("Only Sons Grey Slim Fit Zip Polo Shirt ")
                .description("Only Sons Grey Slim Fit Zip Polo Shirt ")
                .price(37)
                .image("men/only-sons-grey-slim-fit-zip-polo-shirt.jpg")
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
                .name("Pale Blue Ripped Knee Baggy Fit Jeans ")
                .description("Pale Blue Ripped Knee Baggy Fit Jeans")
                .price(45)
                .image("men/pale-blue-ripped-knee-baggy-fit-jeans.jpg")
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
                .name("Grey Jacket")
                .description("Jacket for trendy outfit")
                .price(37)
                .image("men/man2.jpg")
                .sale(false)
                .views(2)
                .featured(true)
                .featureImage("men/man2.jpg")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct19);
        Product menProduct20 = Product.builder()
                .createdAt(LocalDateTime.now())
                .categoryId(menCategory.getId())
                .name("Jeans jacket")
                .description("Blue jacket jean summer edition")
                .price(39)
                .image("/men/man1.jpg")
                .sale(false)
                .views(2)
                .featured(true)
                .featureImage("/men/man1.jpg")
                .size("S,M,L,Xl,XXL")
                .build();
        productRepository.save(menProduct20);
    }
}

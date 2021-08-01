package com.sda.java3.ecommerce.services.product;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class SaveProductRequest {
    private String name;
    private String description;
    private double price = 0;
    private String image;
    private boolean sale = false;
    private double salePrice = 0;
    private int views = 0;
    private boolean featured = false;
    private String featureImage;
    private LocalDateTime createdAt;
    private String color;
    private String size;

}

package com.sda.java3.ecommerce.utils;

import lombok.Data;

@Data
public class ProductListFilter {
    protected String query;
    protected String categoryId;
    protected String categoryName;
}

package com.sda.java3.ecommerce.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ec_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID id;

    @Column(name = "name")
    protected String name;

    @Column(name = "description")
    protected String description;

    @Column(name = "price")
    protected double price = 0;

    @Column(name = "image")
    protected String image;

    @Column(name = "sale")
    protected boolean sale = false;

    @Column(name = "sale_price")
    protected double salePrice = 0;

    @Column(name = "views")
    protected int views = 0;

    @Column(name = "featured")
    protected boolean featured = false;

    @Column(name = "featured_image")
    protected String featureImage;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    @Column(name = "category_id")
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID categoryId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "category_id")
    protected Category category;

    @OneToMany(mappedBy = "product")
    protected List<Cart> items;
}

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ec_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID id;

    @Column(name = "product_id")
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID productId;

    @Column(name = "product_description")
    protected String productDescription;

    @Column(name = "product_image")
    protected String productImage;

    @Column(name = "price")
    protected double price;

    @Column(name = "category_id")
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID categoryId;

    @Column(name = "category_name")
    protected String categoryName;

    @Column(name = "quantity")
    protected int quantity;

    @Column(name = "order_id")
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID orderId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "order_id")
    protected Order order;
}

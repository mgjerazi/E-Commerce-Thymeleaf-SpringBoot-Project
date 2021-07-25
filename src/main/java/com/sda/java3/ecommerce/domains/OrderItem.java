package com.sda.java3.ecommerce.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ec_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;

    @Column(name = "product_id")
    protected UUID productId;

    @Column(name = "product_description")
    protected String productDescription;

    @Column(name = "product_image")
    protected String productImage;

    @Column(name = "price")
    protected double price;

    @Column(name = "category_id")
    protected UUID categoryId;

    @Column(name = "category_name")
    protected String categoryName;

    @Column(name = "quantity")
    protected int quantity;

    @Column(name = "order_id")
    protected UUID orderId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "order_id")
    protected Order order;
}

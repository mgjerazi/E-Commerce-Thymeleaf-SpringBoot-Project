package com.sda.java3.ecommerce.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ec_order")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    protected UUID id;

    @Column(name = "address")
    protected String address;

    @Column(name = "total")
    protected double total;

    @Column(name = "user_id")
    protected UUID userId;

    @Column(name = "username")
    protected String userName;

    @OneToMany(mappedBy = "order")
    protected List<OrderItem> items;
}

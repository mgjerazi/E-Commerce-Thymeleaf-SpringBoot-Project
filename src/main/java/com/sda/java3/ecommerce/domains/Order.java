package com.sda.java3.ecommerce.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID id;

    @Column(name = "address")
    protected String address;

    @Column(name = "total")
    protected double total;

    @Column(name = "user_id")
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID userId;

    @Column(name = "username")
    protected String userName;

    @OneToMany(mappedBy = "order")
    protected List<OrderItem> items;
}

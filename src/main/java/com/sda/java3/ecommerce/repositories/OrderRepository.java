package com.sda.java3.ecommerce.repositories;

import com.sda.java3.ecommerce.domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}

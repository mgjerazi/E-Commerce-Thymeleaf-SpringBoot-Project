package com.sda.java3.ecommerce.repositories;

import com.sda.java3.ecommerce.domains.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}

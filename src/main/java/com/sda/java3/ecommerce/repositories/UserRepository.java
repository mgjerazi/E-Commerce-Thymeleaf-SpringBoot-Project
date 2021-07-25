package com.sda.java3.ecommerce.repositories;

import com.sda.java3.ecommerce.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

package com.sda.java3.ecommerce.domains;

import com.sda.java3.ecommerce.utils.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ec_user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    protected UUID id;

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    @Enumerated(value = EnumType.STRING)
    protected UserRole role;
    private LocalDateTime createdAt;
}

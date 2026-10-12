package com.sda.java3.ecommerce.domains;

import com.sda.java3.ecommerce.utils.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
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
@Table(name = "ec_user")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
//    @Type(type = "org.hibernate.type.UUIDCharType")
    @JdbcTypeCode(SqlTypes.CHAR)
    protected UUID id;

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    @Enumerated(value = EnumType.STRING)
    protected UserRole role;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    protected List<Cart> items;
}

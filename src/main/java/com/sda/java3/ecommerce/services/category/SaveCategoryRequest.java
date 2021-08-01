package com.sda.java3.ecommerce.services.category;
import lombok.Data;
import java.util.UUID;
@Data
public class SaveCategoryRequest {
    private UUID id = UUID.fromString("00000000-0000-0000-0000-000000000000");
    protected String name;
}

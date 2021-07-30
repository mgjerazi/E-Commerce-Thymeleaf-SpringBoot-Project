package com.sda.java3.ecommerce.utils;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Breadcrumb {
    protected String url;
    protected String name;
    boolean last = false;
}

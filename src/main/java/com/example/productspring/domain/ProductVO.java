package com.example.productspring.domain;

import lombok.*;

@ToString
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    private int id;
    private String name;
    private int price;
    private int quantity;
}

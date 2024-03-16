package com.example.productspring.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    @Min(value = 0, message = "가격은 양수여야 합니다.")
    @Max(value = 1000000, message = "가격은 1,000,000을 초과할 수 없습니다.")
    private int price;
    @Min(value = 0, message = "재고수량은 양수여야합니다.")
    @Max(value = 99999, message = "재고수량은 99999를 초과할 수 없습니다.")
    private int quantity;
}

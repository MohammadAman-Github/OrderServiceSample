package com.demo.orderservicesample.DTOs;

import lombok.Data;

@Data
public class ProductDto {
    private long productId; // Product ID
    private int quantity; // Quantity of the product
}

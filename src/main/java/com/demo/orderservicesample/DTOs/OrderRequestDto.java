package com.demo.orderservicesample.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {

    public List<ProductDto> products; // List of product IDs and quantities
}


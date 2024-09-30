package com.demo.orderservicesample.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ProductDetailsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productNo ; // Primary key for product details

    private  long productId;
    private  String name;
    private  String description;
    private  String image;
    private  double price;
    private  String category;
    private int quantity;

}

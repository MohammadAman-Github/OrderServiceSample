package com.demo.orderservicesample.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Order_Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<ProductDetailsTable> productDetailsTables;
    private double TotalAmount;


    public Order_Table(List<ProductDetailsTable> productDetailsTableList, double totalAmount) {
        this.productDetailsTables = productDetailsTableList;
        this.TotalAmount = totalAmount;
    }

    public Order_Table() {

    }
}

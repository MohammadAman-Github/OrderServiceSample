package com.demo.orderservicesample.Service;

import com.demo.orderservicesample.DTOs.OrderRequestDto;
import com.demo.orderservicesample.Exception.OrderNotFoundException;
import com.demo.orderservicesample.Models.Order_Table;

public interface OrderService {
    Order_Table createOrder(OrderRequestDto OrderRequest) throws OrderNotFoundException;
    Order_Table getOrderById(Long OrderId) throws OrderNotFoundException;

}

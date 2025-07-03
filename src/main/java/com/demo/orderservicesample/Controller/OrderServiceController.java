package com.demo.orderservicesample.Controller;

import com.demo.orderservicesample.DTOs.OrderRequestDto;
import com.demo.orderservicesample.Exception.OrderNotFoundException;
import com.demo.orderservicesample.Models.Order_Table;
import com.demo.orderservicesample.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderServiceController {

        @Autowired
        public OrderService orderService;

        @PostMapping("/orders")
        public ResponseEntity<Order_Table> createorder(@RequestBody OrderRequestDto OrderDto) throws OrderNotFoundException{

            Order_Table order = orderService.createOrder(OrderDto);
            return new ResponseEntity<>(order, HttpStatusCode.valueOf(200));
        }


        @GetMapping("/OrderId/{id}")
        public ResponseEntity<Order_Table> getOrderId(@PathVariable Long id) throws OrderNotFoundException {
            Order_Table order = orderService.getOrderById(id);
            return new ResponseEntity<>(order, HttpStatusCode.valueOf(200));
        }

}




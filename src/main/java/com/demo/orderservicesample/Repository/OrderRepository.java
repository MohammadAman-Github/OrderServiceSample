package com.demo.orderservicesample.Repository;

import com.demo.orderservicesample.Models.Order_Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order_Table, Long> {
    Order_Table getOrderByOrderId(Long orderId);
    Optional<Order_Table> findByOrderId(Long orderId);
}

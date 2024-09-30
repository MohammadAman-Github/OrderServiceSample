package com.demo.orderservicesample.Service;

import com.demo.orderservicesample.DTOs.OrderRequestDto;
import com.demo.orderservicesample.DTOs.ProductDto;
import com.demo.orderservicesample.Exception.OrderNotFoundException;
import com.demo.orderservicesample.Models.Order_Table;
import com.demo.orderservicesample.Models.ProductDetailsTable;
import com.demo.orderservicesample.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order_Table createOrder(OrderRequestDto OrderRequest) throws OrderNotFoundException {

        // Create a list to store product details
        List<ProductDetailsTable> productDetailsTableList = new ArrayList<>();
        double TotalAmount = 0.0;




        // Loop through the products int the DTO, fetch product details , and calculate total

        for (ProductDto productDto : OrderRequest.getProducts()) {
            // Fetch product details from the Product Service ( assuming a REST API call)
            String ProductServiceUrl = "http://localhost:8081/Products/" + productDto.getProductId();
            RestTemplate restTemplate = new RestTemplate();
            ProductDetailsTable fetchedProductDetails = restTemplate.getForObject(ProductServiceUrl, ProductDetailsTable.class);

            if (fetchedProductDetails != null) {
                // Create a new instance for the order
                ProductDetailsTable productDetailsTable = new ProductDetailsTable();
                productDetailsTable.setProductId(productDto.getProductId());
                productDetailsTable.setName(fetchedProductDetails.getName());
                productDetailsTable.setDescription(fetchedProductDetails.getDescription());
                productDetailsTable.setImage(fetchedProductDetails.getImage());
                productDetailsTable.setPrice(fetchedProductDetails.getPrice());
                productDetailsTable.setCategory(fetchedProductDetails.getCategory());
                productDetailsTable.setQuantity(productDto.getQuantity());

                // Calculate the total amount for this product and add it to the Total

                double OrderTotalAmount = productDetailsTable.getPrice() * productDto.getQuantity();
                TotalAmount += OrderTotalAmount;

                // Add the product details to the list
                productDetailsTableList.add(productDetailsTable);
            }
        }

        Order_Table order_table = new Order_Table(productDetailsTableList, TotalAmount);
        orderRepository.save(order_table);

        return order_table;
    }


    @Override
    public Order_Table getOrderById(Long OrderId) throws OrderNotFoundException {
        Order_Table order = orderRepository.getOrderByOrderId(OrderId);
        if (order == null) {
            throw new OrderNotFoundException("Order with OrderId " + OrderId + " was not found");
        }

        return order;
    }
}






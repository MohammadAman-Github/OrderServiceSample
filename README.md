A Spring Boot-based REST API that manages order creation by integrating with a separate ProductService. It fetches real-time product details (name, price, etc.) via REST before storing the order.
🧩 Project Overview

This project demonstrates:

    Creating REST APIs for placing and retrieving orders.

    Consuming external REST APIs using RestTemplate (integrated with ProductService).

    Applying business logic like total price calculation and quantity handling.

    Managing relational data using JPA with MySQL.

    Centralized exception handling using @ControllerAdvice.

    Clean separation of concerns using Controller, Service, Repository, and DTO layers.
⚙️ Tech Stack

    Java 17 / Java 22
    The primary programming language used for backend development and business logic.

    Spring Boot
    A framework that streamlines application configuration, dependency injection, and RESTful API development.

    Spring Web
    Handles HTTP requests and builds RESTful services.

    Spring Data JPA
    Provides seamless integration with relational databases using JPA and Hibernate.

    MySQL
    A relational database is used to store order and product data.

    Lombok
    Reduces boilerplate code using annotations like @Data, @Getter, and @Setter.

    RestTemplate
    Used for making HTTP calls to external services — here, it's used to integrate with ProductService.

    Maven
    Dependency and project build management tool.
📌 Features

    ✅ Create orders with product quantity

    ✅ Fetch product details from ProductService using REST

    ✅ Calculate and store the total amount

    ✅ Get order details by orderId

    ✅ Exception handling for order not found

    ✅ Design structure with DTOs, Models, Services, and Controllers.

🔗 Integration

This service depends on ProductService to fetch product data using HTTP calls like:

GET http://localhost:8081/Products/{productId}

So, make sure ProductService is running before creating an order.
📬 Sample Request (Create Order)

POST /orders
Content-Type: application/json

{
  "products": [
    { "productId": 1, "quantity": 2 },
    { "productId": 3, "quantity": 1 }
  ]
}

⚙️ How to Run

Clone the repository:

git clone https://github.com/MohammadAman-Github/OrderServiceSample.git

Configure MySQL:

Create a database named order_service_sample (or any name) and update your application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/order_service_sample
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Run the Application:

You can run the application from the OrderServiceSampleApplication.java class or using:

mvn spring-boot:run

API Endpoints:

    POST /orders — Create a new order

    GET /OrderId/{id} — Get order by ID

📂 Project Structure

src/main/java/
│
├── Controller
├── DTOs
├── Exception
├── Models
├── Repository
├── Service
└── Thread  ← (practice problems)

🚧 Future Improvements

Add validation for productId and quantity

Handle the case when the ProductService is down

👨‍💻 Author

Mohammad Aman
Java Backend Developer | Spring Boot | MySQL | REST APIs
📌 Building real-world APIs with clean code and solid architecture
https://github.com/MohammadAman-Github

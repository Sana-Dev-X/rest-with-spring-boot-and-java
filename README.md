# REST API with Spring Boot and Java

This repository contains my practical studies on REST API development using Spring Boot, Java, Swagger/OpenAPI, MySQL, and other related technologies.

📋 Description

The project implements a complete REST API demonstrating fundamental concepts such as:

*   Creating REST endpoints

*   Global exception handling

*   Automatic API documentation

*   Structuring Spring Boot projects

*   Mathematical operations via API

🛠 Technologies Used

*   Java 25

*   Spring Boot

*   Spring Web

*   Spring Data JPA

*   MySQL

*   Swagger/OpenAPI

*   Maven

📁 Project Structure

    src/main/java/br/com/sanadev/rest_with_spring_boot_and_java/
    ├── controller/                    # REST Controllers
    │   ├── GreetingController.java    # Greeting endpoints
    │   └── MathController.java        # Mathematical operations endpoints
    ├── exception/                     # Custom exceptions
    │   ├── ExceptionResponse.record   # Record for exception response
    │   └── UnsupportedMathOperationException.exception
    ├── exception/handler/             # Global exception handler
    │   └── CustomEntityResponseHandler.java
    ├── model/                         # Models/Entities
    │   └── Greeting.java
    └── Startup.java                   # Main application class

🚀 How to Run

Prerequisites

*   Java 17 or higher

*   Maven 3.6+

*   MySQL 8.0+

*   IDE (IntelliJ, Eclipse, or VS Code)

Database Configuration

Create a MySQL database:

    CREATE DATABASE rest_api_study;

Configure the credentials in application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/rest_api_study
    spring.datasource.username=root
    spring.datasource.password=admin
    spring.jpa.hibernate.ddl-auto=update

Running the Application

Clone the repository

    git clone https://github.com/Sana-Dev-X/rest-with-spring-boot-and-java.git

Navigate to the directory

    cd rest-with-spring-boot-and-java

Run with Maven

    mvn spring-boot:run

The application will be available at:

    http://localhost:8080

📚 API Endpoints

Greeting Controller

*   GET /greeting - Returns a basic greeting

*   GET /greeting/{name} - Returns a personalized greeting

Math Controller

*   GET /math/sum/{numberOne}/{numberTwo} - Sum of two numbers

*   GET /math/subtraction/{numberOne}/{numberTwo} - Subtraction of two numbers

*   GET /math/multiplication/{numberOne}/{numberTwo} - Multiplication of two numbers

*   GET /math/division/{numberOne}/{numberTwo} - Division of two numbers

*   GET /math/mean/{numberOne}/{numberTwo} - Average of two numbers

*   GET /math/squareRoot/{number} - Square root of a number

📖 API Documentation

The interactive API documentation will soon be available via Swagger UI

🎯 Learning Objectives

*   Spring Boot project configuration

*   Creation of REST controllers

*   Implementation of CRUD endpoints

*   Global exception handling

*   Swagger/OpenAPI configuration

*   MySQL integration

*   Structuring packages following best practices

*   Unit and integration tests

*   Authentication and authorization

*   Cloud deployment

📝 Study Notes

This project is part of my learning journey in backend development with Spring Boot. Each component was implemented to practically understand the fundamental concepts.

Concepts Covered:

*   Inversion of Control (IoC) and Dependency Injection (DI)

*   Controllers and Endpoint Mapping

*   Exception Handling with @ControllerAdvice

*   Java Records for immutable objects

*   Automatic Documentation with Swagger

*   MySQL Database Configuration

🔄 Next Steps

*   Add JWT authentication

*   Implement tests with JUnit and Mockito

*   Add cache with Redis

*   Implement structured logging

*   Configure Docker and Docker Compose

*   Add monitoring with Actuator

🤝 Contribution

As this is a study repository, suggestions and tips are welcome! Feel free to open issues or pull requests.

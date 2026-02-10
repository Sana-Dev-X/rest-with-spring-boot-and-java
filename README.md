# REST API with Spring Boot and Java

This repository contains my practical studies on REST API development using Spring Boot, Java, Swagger/OpenAPI, MySQL, and other related technologies.

📋 **Description**

* The project implements a complete REST API demonstrating fundamental concepts such as:

* Creating REST endpoints

* Global exception handling

* Automatic API documentation

* Structuring Spring Boot projects

* Mathematical operations via API

* CRUD operations with database integration

* Input validation and error handling

🛠 **Technologies Used**

* Java 17+

* Spring Boot 3.x

* Spring Web

* Spring Data JPA

* MySQL 8.0+

* Swagger/OpenAPI (SpringDoc)

* Maven

* Docker (planned)

📁 **Project Structure**

        rest-with-spring-boot-and-java/
        ├── src/main/java/br/com/sanadev/rest_with_spring_boot_and_java/
        │   ├── Startup.java
        │   ├── config/
        │   ├── greetings/
        │   │   ├── controller/
        │   │   │   └── GreetingController.java
        │   │   └── model/
        │   │       └── Greeting.java
        │   ├── math/
        │   │   ├── controller/
        │   │   │   └── MathController.java
        │   │   ├── exception/
        │   │   │   ├── ExceptionResponse.java
        │   │   │   ├── UnsupportedMathOperationException.java
        │   │   │   └── handler/
        │   │   │       └── CustomEntityResponseHandlerForMathClasses.java
        │   │   ├── service/
        │   │   │   └── MathService.java
        │   │   └── tools/
        │   │       ├── NumberConverter.java
        │   │       └── ParamValidator.java
        │   └── person/
        │       ├── controller/
        │       │   └── PersonController.java
        │       ├── exception/
        │       │   ├── ExceptionResponse.java
        │       │   ├── ResourceNotFoundException.java
        │       │   └── handler/
        │       │       └── CustomEntityResponseHandler.java
        │       ├── mock/
        │       │   └── Mock.java
        │       ├── model/
        │       │   └── Person.java
        │       ├── repository/
        │       │   └── PersonRepository.java
        │       └── service/
        │           └── PersonService.java
        ├── src/main/resources/
        │   ├── application.properties
        │   └── application-dev.properties
        ├── src/test/java/
        │   └── [test packages mirror main structure]
        ├── pom.xml
        ├── docker-compose.yml (planned)
        ├── Dockerfile (planned)
        └── README.md  

🚀 **How to Run**

Prerequisites

*   Java 17 or higher

*   Maven 3.6+

*   MySQL 8.0+

*   IDE (IntelliJ, Eclipse, or VS Code)

Database Configuration

Create a MySQL database:

    CREATE DATABASE rest_with_spring_boot_and_java;

Configure the credentials in application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/rest_with_spring_boot_and_java
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

📚 **API Endpoints**

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

Person Controller (CRUD Operations)

*   GET /person - List all persons

*   GET /person/{id} - Find person by ID

*   POST /person - Create new person

*   PUT /person/{id} - Update existing person

*   DELETE /person/{id} - Delete person

📖 **API Documentation**

The interactive API documentation will soon be available via Swagger UI

🎯 **Learning Objectives**

*   Spring Boot project configuration and auto-configuration

*   Creation of REST controllers with proper HTTP methods

*   Implementation of CRUD operations with Spring Data JPA

*   Global exception handling with @ControllerAdvice

*   Input validation and custom validators

*   Swagger/OpenAPI configuration for automatic documentation

*   MySQL integration and entity mapping

*   Proper package structuring following best practices

*   Service layer abstraction and business logic separation

*   Repository pattern implementation

📝 **Study Notes**

This project is part of my learning journey in backend development with Spring Boot. Each component was implemented to practically understand the fundamental concepts.

Concepts Covered:

*	Inversion of Control (IoC) and Dependency Injection (DI) - Spring container management

*	Controllers and Endpoint Mapping - @RestController, @RequestMapping, HTTP method annotations

*	Exception Handling - Global exception handling with @ExceptionHandler and @ControllerAdvice

*	Data Persistence - Entity mapping, Spring Data JPA repositories

*	Service Layer - Business logic separation and transaction management

*	Input Validation - Custom validators and parameter validation

*	Project Structure - Organized by feature/module

*	Configuration - Externalized configuration with application.properties

🔄 **Next Steps & Roadmap**

Short-term Goals:


*	Add comprehensive unit tests with JUnit 5 and Mockito

*	Implement integration tests with Testcontainers

*	Add validation annotations (Jakarta Validation)

*	Implement pagination and sorting for list endpoints

*	Add structured logging with SLF4J

*	Medium-term Goals:

*	Add JWT authentication and authorization

*	Implement role-based access control (RBAC)

*	Add caching with Spring Cache and Redis

*	Configure Docker and Docker Compose for containerization

*	Add monitoring with Spring Boot Actuator

*	Implement API versioning

Long-term Goals:


*	Add CI/CD pipeline with GitHub Actions

*	Implement message queue integration (RabbitMQ/Kafka)

*	Add distributed tracing with Sleuth/Zipkin

*	Deploy to cloud platform (AWS/Azure/GCP)

*	Implement GraphQL endpoints alongside REST

🤝 Contribution

As this is a study repository, suggestions and tips are welcome! Feel free to open issues or pull requests.

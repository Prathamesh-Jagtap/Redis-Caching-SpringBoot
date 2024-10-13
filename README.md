# Spring Boot Product Service with Caching

This Spring Boot application provides a service for handling CRUD operations (Create, Read, Update, Delete) on `Products` entities. It uses Spring's caching mechanism to improve performance by reducing the number of database calls.

# Features

- **CRUD Operations**: Perform basic Create, Read, Update, and Delete operations on `Products`.
- **Caching**: Implements caching using Spring's `@Cacheable` and `@CacheEvict` annotations to optimize data retrieval.
- **Error Handling**: Throws a `RecordNotFoundException` when an entity is not found in the database.

# Technologies Used

- Spring Boot 3.x
- Spring Data JPA
- Spring Cache (with EhCache, Redis, or another caching provider)
- Lombok
- Maven

# Prerequisites

- Java 17 or higher
- Maven 3.x
- A caching provider (EhCache, Redis, etc.) configured in your Spring Boot application.

# Getting Started

# Clone the repository
```bash
https://github.com/Prathamesh-Jagtap/Redis-Caching-SpringBoot.git
cd spring-boot-product-service
```

# Build and Run project
```bash
mvn clean install
mvn spring-boot:run
```

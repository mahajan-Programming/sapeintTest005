# sapeintTest005

# Sapient Test Service

This project demonstrates the implementation of a `UserService` in Spring Boot, . It fetches and processes user data using a REST API and saves it to a database.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [Contributing](#contributing)
- [License](#license)

## Features
- Fetches user data from a remote API (`https://dummyjson.com/users`).
- Saves fetched data into a database using `UserRepository`.
- Provides sorting and filtering of users by roles and other attributes.
- Comprehensive unit tests for all major methods in the service.

## Technologies Used
- **Java 11**
- **Spring Boot 2.x**
- **REST Template** for API integration

## Setup and Installation

### Prerequisites
- Java Development Kit (JDK 17 )
- Maven (for dependency management)
- An IDE like IntelliJ IDEA or Eclipse

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/sapient-test-service.git


Navigate to the project directory:
cd sapient-test-service

Build the project using Maven:
mvn clean install

Running the Application
Start the application:
mvn spring-boot:run

Access the application (if applicable):
REST API: http://localhost:8080



src/main/java
├── com.sapient.test.SapientTest
│   ├── dto        # DTO classes
│   ├── entity     # JPA entities
│   ├── repository # Data repository layer
│   └── service    # Service layer (includes UserService)

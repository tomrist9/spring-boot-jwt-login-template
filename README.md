## 🌐 Spring Boot JWT Authentication Template

[![Java](https://img.shields.io/badge/Java-17-red.svg)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green.svg)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6-brightgreen.svg)](https://spring.io/projects/spring-security)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

A production-ready template for building secure REST APIs with **Spring Boot 3** and **JWT (JSON Web Tokens)**.  
This project demonstrates how to implement stateless authentication and role-based authorization using Spring Security.

---

## ✨ Features
- 🔑 **JWT Authentication** (login endpoint, token generation, refresh token support)  
- 🛡️ **Role-Based Access Control** (e.g., `USER`, `ADMIN`)  
- 📦 **Stateless Security** (no session storage, scalable APIs)  
- 🧪 **Exception Handling** for invalid/expired tokens  
- 📝 **Ready-to-Use REST Endpoints**  
- ⚡ Built with **Spring Boot 3**, **Spring Security 6**, **Maven/Gradle**  

---

## 📂 Project Structure
src/main/java/com/example/jwt
│── config/ # Spring Security configuration
│── controller/ # REST endpoints (login, secured APIs)
│── dto/ # Request/Response DTOs
│── model/ # Entities (User, Role)
│── repository/ # Spring Data JPA Repositories
│── service/ # UserDetailsService, JWT Service
│── util/ # JWT utility class


---

## 🚀 Getting Started

### Clone the repository
```bash
git clone https://github.com/tomrist9/spring-boot-jwt-template.git
cd spring-boot-jwt-template

Configure Database

Update application.yml (or application.properties) with your PostgreSQL/MySQL credentials:

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/jwt_demo
    username: postgres
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

Run the Application
./mvnw spring-boot:run


or

./gradlew bootRun

🔐 API Endpoints
Authentication

POST /api/auth/login → Generate JWT token
Request:

{
  "username": "user",
  "password": "password"
}


Response:

{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR...",
  "tokenType": "Bearer"
}

Secured API

GET /api/users/me → Get current user info (requires JWT token in header)

Example:

GET /api/users/me
Authorization: Bearer <JWT_TOKEN>

## 🛠️ Tech Stack

Java 17

Spring Boot 3

Spring Security 6

JWT (jjwt library)

PostgreSQL/MySQL

Maven/Gradle



## 📸 Screenshots

![Register Success](src/main/resources/static/screenshots/register_success.png)
![JWT Token](src/main/resources/static/screenshots/jwt_token.png)
![My Account Success](src/main/resources/static/screenshots/myaccount_success.png)





## 📌 Use Cases

This template can be used to:
- Secure microservices with JWT  
- Build a starter kit for SaaS products  
- Integrate with frontend apps (React, Angular, Vue)  

---

## 💡 Next Steps
- Add **Refresh Tokens**  
- Add **Unit/Integration Tests**  
- Extend with **OAuth2 Login** (Google, GitHub, Facebook)  

---

## 🧑‍💻 Author
Built with ❤️ by [Tomris Teymurlu](https://github.com/tomrist9)

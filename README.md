# Attendance Management System

## 📌 Project Overview
A role-based attendance management system built using Spring Boot.
Supports Admin, Teacher, and Student roles with secure JWT-based authentication.

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- PostgreSQL
- Swagger / OpenAPI

## 🔐 Authentication Flow
- User logs in using email and password
- Backend generates a JWT token
- Client sends token in `Authorization: Bearer <token>`
- JWT filter validates token for every protected request

## 👥 Role-Based Access Control
- **ADMIN**
  - Create users
  - Create students
  - Create teachers
- **TEACHER**
  - Mark attendance
  - View attendance records
- **STUDENT**
  - View own attendance records

## ▶️ How to Run Locally

```bash
mvn spring-boot:run
```
Server runs on:
http://localhost:8080

API Documentation:
Swagger UI:
http://localhost:8080/swagger-ui/index.html

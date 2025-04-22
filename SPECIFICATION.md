# Reviews API - Project Specification

## 1. Project Overview
The Reviews API is a backend service where authenticated users can post reviews, rate products, comment on reviews, like/dislike reviews, and report inappropriate content.  
It is designed to be scalable, secure, and production-ready.

---

## 2. Core Functional Requirements

| Feature                 | Description                                                                                     |
|:------------------------|:------------------------------------------------------------------------------------------------|
| User Registration/Login | Users register and log in using email and password. JWT token is issued for sessions.           |
| Product Management      | Admins can create, update, delete products. Users can view products.                            |
| Reviews                 | Users can post reviews about products (text, rating 1–5 stars, optional media upload).          |
| Likes/Dislikes          | Users can like or dislike reviews. Only one action per review.                                  |
| Comments                | Users can comment on reviews.                                                                   |
| Reporting System        | Users can report a review for inappropriate content. Moderators can review and resolve reports. |
| Media Upload            | Users can upload images/videos to their reviews. Media stored in cloud (e.g., AWS S3).          |
| Caching                 | Hot reviews are cached using Redis for performance.                                             |
| API Documentation       | Public APIs documented with Swagger/OpenAPI 3.0.                                                |
| Admin Panel (Backend)   | Admins and Moderators have role-based access to manage products, reviews, and reports.          |

---

## 3. Non-Functional Requirements

- High availability
- Horizontal scalability
- Secure authentication (JWT)
- Proper error handling (global exception handling)
- Pagination and Sorting for all list endpoints
- Validation of all input
- Rate limiting (optional)
- Clear code separation and clean architecture

---

## 4. Tech Stack

| Layer             | Tech                            |
|:------------------|:--------------------------------|
| Language          | Java 21                         |
| Framework         | Spring Boot 3                   |
| Build Tool        | Gradle (Kotlin DSL)             |
| Database          | PostgreSQL 15                   |
| Caching           | Redis 7                         |
| Containerization  | Docker, Docker Compose          |
| Security          | Spring Security + JWT           |
| Object Storage    | AWS S3 (optional)               |
| Async Messaging   | RabbitMQ (optional)             |
| API Documentation | Swagger OpenAPI 3.0             |
| Monitoring        | (Optional) Prometheus + Grafana |

---

## 5. Architecture Overview

- Monolithic Spring Boot Application (initial phase)
- Clean Layered Architecture:
  - **Controller** → **Service** → **Repository** → **Database**
- DTOs used between Controller and Service layers.
- Caching for "Top Rated Reviews" using Redis.
- Background Scheduled Jobs for cleanup/report notifications.

---

## 6. Security

- Passwords hashed with BCrypt.
- JWT for stateless authentication.
- Role-Based Access Control (RBAC):
  - `USER`: Post reviews, comments, likes, reports.
  - `MODERATOR`: Manage reported reviews.
  - `ADMIN`: Manage products, users, reviews.
- Input validation to avoid injection attacks.

---

## 7. Database Design Overview

| Entity       | Relationships                                                                   |
|:-------------|:--------------------------------------------------------------------------------|
| User         | One-to-many Reviews, One-to-many Comments                                       |
| Product      | One-to-many Reviews                                                             |
| Review       | Many-to-one Product, Many-to-one User, One-to-many Comments, Many-to-many Likes |
| Comment      | Many-to-one Review, Many-to-one User                                            |
| Like/Dislike | User and Review join table                                                      |
| Report       | One-to-one Review                                                               |

---

## 8. Endpoints (Example)

| HTTP Method | URI                             | Description                            |
|:------------|:--------------------------------|:---------------------------------------|
| POST        | `/api/v1/auth/register`         | Register new user                      |
| POST        | `/api/v1/auth/login`            | Authenticate user                      |
| GET         | `/api/v1/products`              | List products                          |
| POST        | `/api/v1/products`              | Create product (Admin only)            |
| GET         | `/api/v1/products/{id}/reviews` | Get reviews of a product (pagination)  |
| POST        | `/api/v1/products/{id}/reviews` | Create review                          |
| POST        | `/api/v1/reviews/{id}/like`     | Like a review                          |
| POST        | `/api/v1/reviews/{id}/dislike`  | Dislike a review                       |
| POST        | `/api/v1/reviews/{id}/comments` | Comment on a review                    |
| POST        | `/api/v1/reviews/{id}/report`   | Report a review                        |
| GET         | `/api/v1/reports`               | View reported reviews (Moderator only) |

---

## 9. Validation Rules

| Field        | Validation                                           |
|:-------------|:-----------------------------------------------------|
| Email        | Must be unique, valid format                         |
| Password     | Min 8 characters, mix of upper/lowercase and numbers |
| Review Text  | Max 5000 characters                                  |
| Rating       | 1 to 5 stars                                         |
| Comment Text | Max 2000 characters                                  |

---

## 10. Error Handling

All errors returned in JSON format:

```json
{
  "timestamp": "2025-04-22T12:00:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Field 'rating' must be between 1 and 5",
  "path": "/api/v1/products/123/reviews"
}
```

---

## 11. Caching Strategy

- Cache the Top 10 most-liked reviews for a product using Redis.
- Evict cache when a new review is added or deleted.

---

## 12. Rate Limiting (Optional)

- 100 API requests per IP per minute.
- Bucket4J + Redis backend.

---

## 13. Deployment Plan

- Dockerized app
- Docker Compose for local development (Postgres, Redis, App)
- Can be deployed to AWS EC2, Railway.app, or any VPS.
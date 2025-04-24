# 📄 Cahier des Charges — Reviews API

## 🔹 1. Project Title
**Reviews API** — A backend service to manage product reviews for an e-commerce or platform-based system.

## 🔹 2. Objective
Design and develop a RESTful API to allow users to create, view, update, and delete reviews for products. Products are created automatically by the backend. Each product contains a subject file populated with its reviews.

## 🔹 3. Target Users
- End users of the client website or app (to submit reviews).
- Admins and moderators (to manage or moderate reviews).
- Frontend developers (to consume the API).

## 🔹 4. Key Functionalities

### ✅ Product
- Auto-create if it doesn't exist when a review is submitted.
- Find by name or identifier.
- Exposes:
    - Name
    - Description (optional)
    - Associated Reviews

### ✅ Review
- Submit a review with rating and content.
- Attach review to a product.
- List all reviews for a product.
- Update or delete existing reviews.

### ✅ User Auth
- JWT-based token authentication.
- Only authenticated users can create or modify their reviews.

### ✅ Admin Services
- Moderate or delete any review.
- View all reviews and products.
- Manage users (optional future service).

### ✅ Documentation
- Auto-generated Swagger/OpenAPI docs

### ✅ Logging & Monitoring (future)
- Logs requests and errors.
- Optional metrics (Prometheus/Grafana).

## 🔹 5. Technical Stack

| Layer          | Tech                        |
|----------------|-----------------------------|
| Language       | Java                        |
| Framework      | Spring Boot                 |
| ORM            | JPA + Hibernate             |
| Database       | PostgreSQL                  |
| API Spec       | RESTful + OpenAPI (Swagger) |
| Security       | Spring Security + JWT       |
| DevOps         | Docker + Docker Compose     |
| Deployment     | DigitalOcean Droplet        |
| CI/CD          | GitHub Actions              |
| Env Management | .env + dotenv-spring-boot   |
| Build Tool     | Gradle (Groovy DSL)         |

## 🔹 6. Entity Model

### AbstractEntity (base class)
- `id`, `createdAt`, `updatedAt`, `version`

### Product
- `name`, `description`
- `List<Review> reviews`

### Review
- `content`, `rating`, `createdBy`
- `Product product`

## 🔹 7. API Endpoints (Examples)

| Method | Path                      | Description                                       |
|--------|---------------------------|---------------------------------------------------|
| GET    | /api/products             | List all products                                 |
| GET    | /api/products/{id}        | Get product details                               |
| POST   | /api/reviews              | Create new review (auto-create product if needed) |
| GET    | /api/reviews/product/{id} | List reviews for product                          |
| PUT    | /api/reviews/{id}         | Edit a review                                     |
| DELETE | /api/reviews/{id}         | Delete a review                                   |

## 🔹 8. Deployment Plan
- Deploy on DigitalOcean using Docker.
- Configure NGINX reverse proxy for domain: `reviews-api.saintbassanaga.tech`
- Use `.env` for environment secrets.
- Automate build + deploy via GitHub Actions.

## 🔹 9. Security Requirements
- API must not expose secrets.
- JWT authentication for sensitive actions.
- Secure HTTP headers via Spring Security.
- Optional: Rate limiting & IP filtering.

## 🔹 10. Deliverables
- `README.md` with full usage instructions.
- Docker-ready setup (`docker-compose.yml`).
- `.env.example` for secret management.
- REST API documentation (Swagger).
- GitHub Actions CI/CD pipeline.
- Full GitHub repo (public).
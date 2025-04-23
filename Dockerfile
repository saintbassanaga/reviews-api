# ---- Stage 1: Build ----
FROM gradle:8.7-jdk21 AS builder

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
RUN ./gradlew dependencies --no-daemon || return 0

COPY src ./src
RUN ./gradlew bootJar --no-daemon

# ---- Stage 2: Run ----
FROM gcr.io/distroless/java21-debian12:nonroot

LABEL maintainer="Saint Paul Bassanaga <saintbassanaga01@icloud.com>" \
      org.opencontainers.image.title="Reviews API" \
      org.opencontainers.image.description="Spring Boot 3 API with PostgreSQL and JWT" \
      org.opencontainers.image.version="1.0.0" \
      org.opencontainers.image.authors="Saint Paul Bassanaga"


WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

# Expose port
EXPOSE 8082

# Run the app
ENTRYPOINT ["app.jar"]

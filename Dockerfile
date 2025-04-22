# ---- Stage 1: Build ----
FROM gradle:8.7-jdk21 AS builder

WORKDIR /app

# Copy only the necessary Gradle files first to cache dependencies
COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle

# Preload dependencies
RUN ./gradlew build --no-daemon || return 0

# Copy the rest of the source code
COPY src ./src

# Build the app (skip tests if you want faster builds)
RUN ./gradlew bootJar --no-daemon

# ---- Stage 2: Run ----
FROM openjdk:21-jdk-slim

# Labels
LABEL maintainer="Saint Paul Bassanaga saintbassanaga01@icloud.com"
LABEL org.opencontainers.image.title="Reviews API"
LABEL org.opencontainers.image.description="A scalable Reviews API built with Spring Boot 3, PostgreSQL, Redis, and JWT."
LABEL org.opencontainers.image.version="1.0.0"

WORKDIR /app

# Copy the built JAR from builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose app port
EXPOSE 8080

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]

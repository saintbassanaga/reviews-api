# 🏗 Stage 1: Build the Application
FROM gradle:jdk21-graal AS builder
WORKDIR /app


# Accept build arguments
ARG BUILD_DATE
ARG VCS_REF
ARG VERSION
ARG BUILT_BY

# Labels with dynamic values
LABEL org.opencontainers.image.created=$BUILD_DATE \
      org.opencontainers.image.revision=$VCS_REF \
      org.opencontainers.image.version=$VERSION \
      org.opencontainers.image.authors=$BUILT_BY \
      org.opencontainers.image.title="Reviews API" \
      org.opencontainers.image.description="A scalable Reviews API built with Spring Boot 3, PostgreSQL, Redis, and JWT."

# Copy Gradle config and download dependencies
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN gradle dependencies --no-daemon

# Copy source code and build the JAR
COPY src src
RUN gradle bootJar --no-daemon

# 🔥 Stage 2: Prepare Runtime Layers
FROM ghcr.io/graalvm/graalvm-community:21 AS layertools
WORKDIR /app

# Copy built JAR and extract layers
COPY --from=builder /app/build/libs/*.jar app.jar
RUN java -Djarmode=layertools -jar app.jar extract

# 🚀 Final Stage: Ultra-minimal Distroless Image
FROM gcr.io/distroless/java21-debian12:nonroot

# Set working directory
WORKDIR /app

# Copy only the necessary extracted layers
COPY --from=layertools /app/dependencies/ ./
COPY --from=layertools /app/spring-boot-loader/ ./
COPY --from=layertools /app/snapshot-dependencies/ ./
COPY --from=layertools /app/application/ ./

# Expose application port
EXPOSE 8080

# Set the entrypoint
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]

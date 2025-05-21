package tech.saintbassanaga.reviewsapi.config.handlers;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tech.saintbassanaga.reviewsapi.dtos.ApiResponse;


import java.time.Instant;

/**
 * The RestExceptionHandler is a centralized exception handler for REST APIs in a Spring Boot application,
 * extending the {@link ResponseEntityExceptionHandler}.It provides predefined methods to handle
 * specific exceptions in a consistent and standardized way.

 * The responsibility of this class is to handle exceptions thrown within the application and respond
 * with meaningful and structured JSON-based error messages that can be consumed easily by clients.

 * Features:
 * - Provides a custom implementation for handling {@link EntityNotFoundException}.
 * - Generates a standardized error response using the {@link ApiResponse} class with fields such as
 *   status code, error message, timestamp, and success flag.
 * - Uses {@link ResponseEntity} to encapsulate the HTTP response with status and body for each exception type.

 * Annotations:
 * - {@link RestControllerAdvice} is used to handle exceptions globally across the application
 *   within REST controllers.
 */
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles exceptions of type {@link EntityNotFoundException} by creating and returning a standardized
     * error response encapsulated in a {@link ResponseEntity}.
     *
     * @param exception the {@link EntityNotFoundException} that was thrown.
     * @param webRequest the current {@link WebRequest} during the exception.
     * @return a {@link ResponseEntity} containing an {@link ApiResponse} with details about the error,
     *         including HTTP status, message, timestamp, and a success flag.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> handleException(EntityNotFoundException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ApiResponse errorDto = ApiResponse.builder()
                .message(exception.getMessage())
                .httpStatus(notFound)
                .timestamp(Instant.now())
                .success(false)
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }

    public static class DuplicateUsernameException extends RuntimeException {
        public DuplicateUsernameException(String message) {
            super(message);
        }
    }

}

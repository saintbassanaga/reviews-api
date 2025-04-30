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

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

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

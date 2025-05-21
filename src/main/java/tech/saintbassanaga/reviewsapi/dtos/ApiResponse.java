/**
 * The ApiResponse class is a standardized structure for HTTP responses in the application.
 * It simplifies the process of sending a consistent response format to the client,
 * including success/error status, messages, HTTP status, and optional data payload.
 * API responses are built using the Builder pattern for clarity and flexibility.

 * Author: saintbassanaga
 * Created: 11/03/2025 - 11:34
 */
package tech.saintbassanaga.reviewsapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // Ensures null fields are excluded from the JSON response
public class ApiResponse {

    /**
     * Indicates whether the operation was successful.
     */
    private Boolean success;

    /**
     * A message providing feedback about the operation, e.g., success or error details.
     */
    private String message;

    /**
     * The HTTP status associated with this response, e.g., 200 OK or 400 Bad Request.
     */
    private HttpStatus httpStatus;

    /**
     * A timestamp representing when the response was created.
     */
    private Instant timestamp;

    /**
     * An optional field containing additional data or payload for the response.
     */
    private Object data;

    /**
     * Static utility method to create a standardized success response.
     *
     * @param message - Feedback message for the success case.
     * @param data - Optional payload included in the success response.
     * @return ApiResponse - A pre-built success response.
     */
    public static ApiResponse success(String message, Object data) {
        return ApiResponse.builder()
                .success(true)
                .message(message)
                .httpStatus(HttpStatus.OK) // Default success status is HTTP 200 OK
                .timestamp(Instant.now())
                .data(data)
                .build();
    }

    /**
     * Static utility method to create a standardized error response.
     *
     * @param message - Feedback message describing the error.
     * @param httpStatus - The specific HTTP status for the error response.
     * @return ApiResponse - A pre-built error response.
     */
    public static ApiResponse error(String message, HttpStatus httpStatus) {
        return ApiResponse.builder()
                .success(false)
                .message(message)
                .httpStatus(httpStatus)
                .timestamp(Instant.now())
                .build();
    }
}
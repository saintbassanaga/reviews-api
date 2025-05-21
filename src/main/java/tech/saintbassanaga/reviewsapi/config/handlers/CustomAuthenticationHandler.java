package tech.saintbassanaga.reviewsapi.config.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * CustomAuthenticationHandler is a custom implementation of the AuthenticationEntryPoint interface.
 * It handles unauthorized access attempts by returning a JSON response with an error message and timestamp.

 * This class is used in Spring Security configurations to customize the behavior when authentication fails.

 * Dependencies:
 * - ObjectMapper from Jackson for serializing the response to JSON.
 * - HttpServletRequest and HttpServletResponse for handling HTTP requests and responses.
 * - AuthenticationException for capturing authentication-related exceptions.
 * - HttpStatus for setting the HTTP response status.
 *
 * @author  tech.saintbassanaga.reviewsapi.config.handlers
 */
public class CustomAuthenticationHandler implements AuthenticationEntryPoint {

    // ObjectMapper instance for converting Java objects to JSON strings.
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Handles unauthorized access attempts by sending a JSON response with an error message and timestamp.
     *
     * @param request The HttpServletRequest object that contains the request the client made to the server.
     * @param response The HttpServletResponse object that contains the response the server sends to the client.
     * @param authException The exception thrown when authentication fails.
     * @throws IOException If an input or output exception occurs while writing the response.
     * @throws ServletException If a servlet-specific error occurs.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        // Set the HTTP response status to 401 Unauthorized.
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        // Create a map to hold the response data.
        Map<String, Object> data = new HashMap<>();
        data.put("timestamp", Calendar.getInstance().getTime()); // Add the current timestamp.
        data.put("errorMessage", authException.getLocalizedMessage()); // Add the error message from the exception.

        // Write the response data as a JSON string to the response output stream.
        response.getOutputStream().println(objectMapper.writeValueAsString(data));
    }
}
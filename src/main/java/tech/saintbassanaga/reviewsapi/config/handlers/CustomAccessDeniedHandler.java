package tech.saintbassanaga.reviewsapi.config.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


/**
 * CustomAccessDeniedHandler is a custom implementation of the {@link AccessDeniedHandler} interface
 * used for handling cases where a user tries to access a resource they are not authorized to access.

 * Upon detecting access denial, this handler sets the HTTP response status to 401 Unauthorized
 * and returns a JSON response with details about the access denial.

 * Features included:
 * - Sets the HTTP response status code to 401 (Unauthorized).
 * - Generates a JSON response containing the timestamp of the event and the related error message.

 * Dependencies:
 * - Relies on {@link ObjectMapper} to serialize the response data into JSON format.
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        Map<String, Object> data=new HashMap<>();
        data.put("timestamp", Calendar.getInstance().getTime());
        data.put("errorMessage",accessDeniedException.getMessage());
        response.getOutputStream().println(objectMapper.writeValueAsString(data));
    }
}

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
 * @author hmekeng
 * @created 10/03/2025 - 13:45
 * @project mercurial-rest
 * @package com.siic.dgls.mercurial.handlers
 */
public class CustomAuthenticationHandler implements AuthenticationEntryPoint {
    ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        Map<String, Object> data=new HashMap<>();
        data.put("timestamp", Calendar.getInstance().getTime());
        data.put("errorMessage",authException.getLocalizedMessage());
        response.getOutputStream().println(objectMapper.writeValueAsString(data));
    }

}

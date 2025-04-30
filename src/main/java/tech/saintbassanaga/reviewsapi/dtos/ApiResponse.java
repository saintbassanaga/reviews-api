package tech.saintbassanaga.reviewsapi.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * @author hmekeng
 * @created 11/03/2025 - 11:34
 * @project mercurial-rest
 * @package com.siic.dgls.mercurial.dtos
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private Boolean success;
    private String message;
    private HttpStatus httpStatus;
    private Instant timestamp;
    private Object data;

    public static ApiResponse success(String message, Object data) {
        return ApiResponse.builder()
                .success(true)
                .message(message)
                .httpStatus(HttpStatus.OK)
                .timestamp(Instant.now())
                .data(data)
                .build();
    }

    public static ApiResponse error(String message, HttpStatus httpStatus) {
        return ApiResponse.builder()
                .success(false)
                .message(message)
                .httpStatus(httpStatus)
                .timestamp(Instant.now())
                .build();
    }
}

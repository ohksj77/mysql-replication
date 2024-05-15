package com.replication.backend.config.http;

import java.time.LocalDateTime;

public record ApiResponse<T>(T data, LocalDateTime timestamp) {

    private ApiResponse(T data) {
        this(data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> from(final T data) {
        return new ApiResponse<>(data);
    }
}

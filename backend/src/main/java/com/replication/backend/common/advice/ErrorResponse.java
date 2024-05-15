package com.replication.backend.common.advice;

public record ErrorResponse(String message) {

    public static ErrorResponse from(final Exception exception) {
        return new ErrorResponse(exception.getMessage());
    }
}

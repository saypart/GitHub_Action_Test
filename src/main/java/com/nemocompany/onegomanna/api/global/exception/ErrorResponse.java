package com.nemocompany.onegomanna.api.global.exception;

public record ErrorResponse(
        String errorCode,
        String errorMessage
) {
}
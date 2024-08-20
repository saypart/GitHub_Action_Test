package com.nemocompany.onegomanna.api.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
        var errorResponse = new ErrorResponse(
                exception.getErrorCode().getCode(),
                exception.getMessage()
        );
        log.error("[handleCustomException] {} : {}", exception.getErrorCode().getCode(), exception.getMessage());
        return ResponseEntity.status(exception.getErrorCode().getHttpStatusCode()).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        var errorCode = "ARGUMENT_NOT_VALID";
        var message = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> STR."\{error.getField()}: \{error.getDefaultMessage()}")
                .collect(Collectors.joining());
        var errorResponse = new ErrorResponse(
                errorCode,
                message
        );
        log.error("[handleMethodArgumentNotValidException] {} : {}", errorCode, exception.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception) {
        var errorCode = "INTERNAL_SERVER_ERROR";
        var errorResponse = new ErrorResponse(
                errorCode,
                "서버 에러입니다"
        );
        log.error("[handleRuntimeException] {} : {}", errorCode, exception.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }
}

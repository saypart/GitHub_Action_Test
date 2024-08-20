package com.nemocompany.onegomanna.api.global.exception;

import lombok.Getter;

@Getter
public abstract class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private final Object payload;
    private final Throwable cause;

    protected CustomException(ErrorCode errorCode, Object payload, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
        this.payload = payload;
        this.cause = cause;
    }

    protected CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.payload = new Object();
        this.cause = new Throwable("No cause available");
    }
}

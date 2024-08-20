package com.nemocompany.onegomanna.api.global.exception;

public class RestApiException extends CustomException {

    public RestApiException(ErrorCode errorCode, Object payload, Throwable cause) {
        super(errorCode, payload, cause);
    }

    public RestApiException(ErrorCode errorCode) {
        super(errorCode);
    }
}

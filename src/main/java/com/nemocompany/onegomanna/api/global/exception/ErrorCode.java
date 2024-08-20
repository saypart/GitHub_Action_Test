package com.nemocompany.onegomanna.api.global.exception;

public interface ErrorCode {
    int getHttpStatusCode();
    String getCode();
    String getMessage();
}

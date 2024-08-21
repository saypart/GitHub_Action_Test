package com.nemocompany.onegomanna.api.auth.exception;

import com.nemocompany.onegomanna.api.global.exception.ErrorCode;

public enum AuthErrorCode implements ErrorCode {

    REQUIRED_PARAMETER_MISSING(401, "REQUIRED_PARAMETER_MISSING", "required value is missing"),
    POLICY_NOT_ACCEPTED(401, "POLICY_NOT_ACCEPTED", "policy option is not true");

    private final int httpStatusCode;
    private final String code;
    private final String message;

    AuthErrorCode(int httpStatusCode, String code, String message) {
        this.httpStatusCode = httpStatusCode;
        this.code = code;
        this.message = message;
    }

    @Override
    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

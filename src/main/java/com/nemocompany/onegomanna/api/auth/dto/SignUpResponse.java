package com.nemocompany.onegomanna.api.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignUpResponse(
        @Schema(description = "이름")
        Long userId
) {
    public static SignUpResponse of(Long userId) {
        return new SignUpResponse(userId);
    }
}

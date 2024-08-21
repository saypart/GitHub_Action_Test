package com.nemocompany.onegomanna.api.auth.controller;

import com.nemocompany.onegomanna.api.auth.dto.SignUpRequest;
import com.nemocompany.onegomanna.api.auth.dto.SignUpResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthControllerApi {

    @Operation(summary = "사용자 회원가입", description = "새 사용자를 등록하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "사용자 회원가입 성공")
    })
    ResponseEntity<SignUpResponse> signUp(@RequestBody @Valid SignUpRequest request);
}

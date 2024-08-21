package com.nemocompany.onegomanna.api.auth.controller;

import com.nemocompany.onegomanna.api.auth.dto.SignUpRequest;
import com.nemocompany.onegomanna.api.auth.dto.SignUpResponse;
import com.nemocompany.onegomanna.api.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerApi {
    private final UserService userService;

    @PostMapping("/signup")
    @Override
    public ResponseEntity<SignUpResponse> signUp(SignUpRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(request));
    }
}

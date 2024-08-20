package com.nemocompany.onegomanna.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Operation(summary = "health check", description = "health check API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "서버 정상 가동")
    })
    @GetMapping("/ping")
    public String healthCheck() {
        return "pong";
    }
}

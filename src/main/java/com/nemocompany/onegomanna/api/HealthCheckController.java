package com.nemocompany.onegomanna.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/ping")
    public String healthCheck() {
        return "pong";
    }
}

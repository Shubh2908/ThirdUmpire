package com.TU.auth_service.controller;

import com.TU.auth_service.dto.AuthRequest;
import com.TU.auth_service.dto.AuthResponse;
import com.TU.auth_service.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(
            @RequestBody AuthRequest request
    ) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody AuthRequest request
    ) {

        String token = authService.login(request);

        return new AuthResponse(token);
    }
}

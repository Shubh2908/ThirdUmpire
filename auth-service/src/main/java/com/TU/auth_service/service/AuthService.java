package com.TU.auth_service.service;

import com.TU.auth_service.dto.AuthRequest;
import com.TU.auth_service.entity.User;
import com.TU.auth_service.repo.UserRepo;
import com.TU.auth_service.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public String register(AuthRequest request){

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepo.save(user);

        return "User Registered Successfully";

    }

    public String login(AuthRequest request){

        User user = userRepo.findByUsername(request.getUsername()).orElseThrow();

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())){

            return jwtUtil.generateToken(
                    user.getUsername(),
                    user.getRole().name());
        }

        throw new RuntimeException("Invalid Password");
    }

}

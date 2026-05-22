package com.TU.auth_service.dto;

import com.TU.auth_service.entity.Role;
import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;
    private Role role;

}

package edu.miu.demo.service;

import edu.miu.demo.entity.dto.request.LoginRequest;
import edu.miu.demo.entity.dto.request.RefreshTokenRequest;
import edu.miu.demo.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

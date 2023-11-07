package com.example.tempbe.domain.admin.service;

import com.example.tempbe.domain.admin.controller.request.AdminLoginRequest;
import com.example.tempbe.domain.admin.domain.Admin;
import com.example.tempbe.domain.admin.domain.AdminRepository;
import com.example.tempbe.domain.admin.exception.AdminNotFoundException;
import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import com.example.tempbe.domain.auth.domain.RefreshRepository;
import com.example.tempbe.domain.auth.domain.RefreshToken;
import com.example.tempbe.domain.auth.exception.NotMatchesPasswordException;
import com.example.tempbe.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminLoginService {

    private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshRepository refreshRepository;

    @Transactional
    public TokenResponse execute(AdminLoginRequest request) {
        Admin admin = adminRepository.findByAdminId(request.getAdminId())
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), admin.getPassword())){
            throw NotMatchesPasswordException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.createAccessToken(admin.getAdminId(), admin.getRole());
        String refreshToken = jwtTokenProvider.createRefreshToken(admin.getAdminId(), admin.getRole());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshRepository.save(
                        new RefreshToken(refreshToken)).getToken())
                .build();
    }
}

package com.example.tempbe.domain.admin.service;

import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import com.example.tempbe.domain.auth.domain.RefreshRepository;
import com.example.tempbe.domain.auth.domain.RefreshToken;
import com.example.tempbe.domain.auth.exception.NotFoundRefreshTokenException;
import com.example.tempbe.domain.auth.exception.NotRefreshTokenException;
import com.example.tempbe.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AdminRefreshService {
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshRepository refreshRepository;

    @Transactional
    public TokenResponse execute(String refreshToken) {
        if (!jwtTokenProvider.isRefreshToken(refreshToken)) throw NotRefreshTokenException.EXCEPTION;

        RefreshToken token = refreshRepository.findByToken(refreshToken)
                .orElseThrow(() -> NotFoundRefreshTokenException.EXCEPTION);

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(token.getId().toString(), jwtTokenProvider.getRole(token.getToken())))
                .refreshToken(refreshRepository.save(
                        token.update(jwtTokenProvider.createRefreshToken())).getToken())
                .build();
    }
}

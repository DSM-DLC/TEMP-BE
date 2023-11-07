package com.example.tempbe.domain.auth.service;

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
public class AuthRefreshService {
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshRepository refreshRepository;

    @Transactional
    public TokenResponse execute(String refreshToken) {
        if(!jwtTokenProvider.isRefreshToken(refreshToken)) throw NotRefreshTokenException.EXCEPTION;

        RefreshToken token = refreshRepository.findByToken(refreshToken)
                .orElseThrow(() -> NotFoundRefreshTokenException.EXCEPTION);

        System.out.println(token.getId().toString());
        System.out.println(token.getToken());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.createAccessToken(jwtTokenProvider.getId(token.getToken()), jwtTokenProvider.getRole(token.getToken())))
                .refreshToken(refreshRepository.save(
                        token.update(jwtTokenProvider.createRefreshToken(jwtTokenProvider.getId(token.getToken()), jwtTokenProvider.getRole(token.getToken())))).getToken())
                .build();
    }
}

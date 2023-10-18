package com.example.tempbe.domain.auth.service;

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
public class AuthService {
    private final RefreshRepository refreshRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void logout(String refreshToken){
        if(!jwtTokenProvider.isRefreshToken(refreshToken)) throw NotRefreshTokenException.EXCEPTION;

        RefreshToken token = refreshRepository.findByToken(refreshToken)
                .orElseThrow(() -> NotFoundRefreshTokenException.EXCEPTION);

        refreshRepository.delete(token);
    }
}
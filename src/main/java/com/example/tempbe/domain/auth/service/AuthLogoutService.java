package com.example.tempbe.domain.auth.service;

import com.example.tempbe.domain.auth.domain.RefreshRepository;
import com.example.tempbe.domain.auth.domain.RefreshToken;
import com.example.tempbe.domain.auth.exception.NotFoundRefreshTokenException;
import com.example.tempbe.domain.auth.exception.NotRefreshTokenException;
import com.example.tempbe.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class AuthLogoutService {
    private final RefreshRepository refreshRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTemplate redisTemplate;
    @Transactional
    public void execute(String accessToken, String refreshToken){
        if(!jwtTokenProvider.isRefreshToken(refreshToken)) throw NotRefreshTokenException.EXCEPTION;

        RefreshToken token = refreshRepository.findByToken(refreshToken)
                .orElseThrow(() -> NotFoundRefreshTokenException.EXCEPTION);

        Long expiration = jwtTokenProvider.getExpiration(accessToken.substring(7));
        redisTemplate.opsForValue().set(accessToken.substring(7), "logout", expiration, TimeUnit.MILLISECONDS);

        refreshRepository.delete(token);
    }
}
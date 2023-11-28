package com.example.tempbe.domain.user.service;

import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import com.example.tempbe.domain.auth.domain.RefreshRepository;
import com.example.tempbe.domain.auth.domain.RefreshToken;
import com.example.tempbe.domain.auth.exception.PasswordMisMatchException;
import com.example.tempbe.domain.user.controller.request.UserLoginRequest;
import com.example.tempbe.domain.user.domain.User;
import com.example.tempbe.domain.user.domain.UserRepository;
import com.example.tempbe.domain.user.exception.UserNotFoundException;
import com.example.tempbe.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserLoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshRepository refreshRepository;

    @Transactional
    public TokenResponse execute(UserLoginRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.createAccessToken(user.getUserId(), "user");
        String refreshToken = jwtTokenProvider.createRefreshToken(user.getUserId(), "user");

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshRepository.save(
                        new RefreshToken(refreshToken)).getToken())
                .build();
    }
}

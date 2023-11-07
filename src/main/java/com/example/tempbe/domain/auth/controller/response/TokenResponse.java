package com.example.tempbe.domain.auth.controller.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
}

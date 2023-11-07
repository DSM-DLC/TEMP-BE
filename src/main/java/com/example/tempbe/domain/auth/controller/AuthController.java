package com.example.tempbe.domain.auth.controller;


import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import com.example.tempbe.domain.auth.service.AuthLogoutService;
import com.example.tempbe.domain.auth.service.AuthRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthLogoutService authLogoutService;
    private final AuthRefreshService authRefreshService;

    @DeleteMapping("/logout")
    public void logout(@RequestHeader("Authorization") String accessToken, @RequestHeader("refresh-token") @NotBlank(message = "입력해주세요.") String refreshToken){
        authLogoutService.execute(accessToken, refreshToken);
    }

    @PutMapping("/refresh")
    public TokenResponse refreshToken(@RequestHeader("refresh-token") @NotBlank(message = "입력해주세요.") String refreshToken) {
        return authRefreshService.execute(refreshToken);
    }
}

package com.example.tempbe.domain.auth.controller;


import com.example.tempbe.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    @DeleteMapping("/logout")
    public void logout(@RequestHeader("refresh-token") @NotBlank(message = "입력해주세요.") String refreshToken){
        authService.logout(refreshToken);
    }
}

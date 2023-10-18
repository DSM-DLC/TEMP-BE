package com.example.tempbe.domain.admin.controller;

import com.example.tempbe.domain.admin.controller.request.AdminLoginRequest;
import com.example.tempbe.domain.admin.service.AdminLoginService;
import com.example.tempbe.domain.admin.service.AdminRefreshService;
import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {
    private final AdminLoginService adminLoginService;
    private final AdminRefreshService adminRefreshService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid AdminLoginRequest request){
        return adminLoginService.execute(request);
    }

    @PutMapping("/refresh")
    public TokenResponse refreshToken(@RequestHeader("refresh-token") @NotBlank(message = "입력해주세요.") String refreshToken) {
        return adminRefreshService.execute(refreshToken);
    }
}
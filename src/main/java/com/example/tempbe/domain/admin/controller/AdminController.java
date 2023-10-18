package com.example.tempbe.domain.admin.controller;

import com.example.tempbe.domain.admin.controller.request.AdminLoginRequest;
import com.example.tempbe.domain.admin.service.AdminLoginService;
import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {
    private final AdminLoginService adminLoginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid AdminLoginRequest request){
        return adminLoginService.execute(request);
    }
}
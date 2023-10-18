package com.example.tempbe.domain.user.controller;

import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import com.example.tempbe.domain.user.controller.request.UserLoginRequest;
import com.example.tempbe.domain.user.service.UserLoginService;
import com.example.tempbe.domain.user.service.UserRefreshService;
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
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserLoginService userLoginService;
    private final UserRefreshService userRefreshService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        return userLoginService.execute(userLoginRequest);
    }

    @PutMapping("/refresh")
    public TokenResponse refreshToken(@RequestHeader("refresh-token") @NotBlank(message = "입력해주세요.") String refreshToken) {
        return userRefreshService.execute(refreshToken);
    }
}

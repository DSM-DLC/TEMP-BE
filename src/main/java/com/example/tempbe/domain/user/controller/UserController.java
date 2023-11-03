package com.example.tempbe.domain.user.controller;

import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import com.example.tempbe.domain.user.controller.request.UserLoginRequest;
import com.example.tempbe.domain.user.controller.response.UserProfileResponse;
import com.example.tempbe.domain.user.service.UserLoginService;
import com.example.tempbe.domain.user.service.UserProfileService;
import com.example.tempbe.domain.user.service.UserRefreshService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserLoginService userLoginService;
    private final UserRefreshService userRefreshService;
    private final UserProfileService userProfileService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        return userLoginService.execute(userLoginRequest);
    }

    @PutMapping("/refresh")
    public TokenResponse refreshToken(@RequestHeader("refresh-token") @NotBlank(message = "입력해주세요.") String refreshToken) {
        return userRefreshService.execute(refreshToken);
    }

    @GetMapping("/profile")
    public UserProfileResponse profile(){
        return userProfileService.execute();
    }
}

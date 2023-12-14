package com.example.tempbe.domain.user.controller;

import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import com.example.tempbe.domain.user.controller.request.UserLoginRequest;
import com.example.tempbe.domain.user.controller.request.UserPasswordUpdateRequest;
import com.example.tempbe.domain.user.controller.request.UserProfileUpdateRequest;
import com.example.tempbe.domain.user.controller.response.UserProfileResponse;
import com.example.tempbe.domain.user.service.UserLoginService;
import com.example.tempbe.domain.user.service.UserPasswordUpdateService;
import com.example.tempbe.domain.user.service.UserProfileService;
import com.example.tempbe.domain.user.service.UserProfileUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserLoginService userLoginService;
    private final UserProfileService userProfileService;
    private final UserProfileUpdateService userProfileUpdateService;
    private final UserPasswordUpdateService userPasswordUpdateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest userLoginRequest){
        return userLoginService.execute(userLoginRequest);
    }

    @GetMapping("/profile")
    public UserProfileResponse profile(){
        return userProfileService.execute();
    }

    @PatchMapping("/profile/update")
    public void profileUpdate(@RequestBody @Valid UserProfileUpdateRequest request){
        userProfileUpdateService.execute(request);
    }

    @PatchMapping("/password")
    public void passwordUpdate(@RequestBody @Valid UserPasswordUpdateRequest request) {
        userPasswordUpdateService.execute(request);
    }
}

package com.example.tempbe.domain.admin.controller;

import com.example.tempbe.domain.admin.controller.request.AdminChangePasswordRequest;
import com.example.tempbe.domain.admin.controller.request.AdminLoginRequest;
import com.example.tempbe.domain.admin.controller.request.IssueRequest;
import com.example.tempbe.domain.admin.controller.response.AdminProfileResponse;
import com.example.tempbe.domain.admin.service.*;
import com.example.tempbe.domain.auth.controller.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {
    private final AdminLoginService adminLoginService;
    private final AdminRefreshService adminRefreshService;
    private final AdminIssueService adminIssueService;
    private final AdminProfileService adminProfileService;
    private final AdminChangePasswordService adminChangePasswordService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid AdminLoginRequest request){
        return adminLoginService.execute(request);
    }

    @PutMapping("/refresh")
    public TokenResponse refreshToken(@RequestHeader("refresh-token") @NotBlank(message = "입력해주세요.") String refreshToken) {
        return adminRefreshService.execute(refreshToken);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/issue")
    public void issue(@RequestBody @Valid IssueRequest request){
        adminIssueService.execute(request);
    }

    @GetMapping("/profile")
    public AdminProfileResponse profile(){
        return adminProfileService.execute();
    }

    @PatchMapping("/password")
    public void changePassword(@RequestBody @Valid AdminChangePasswordRequest request){
        adminChangePasswordService.execute(request);
    }
}
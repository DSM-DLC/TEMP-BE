package com.example.tempbe.domain.admin.controller;

import com.example.tempbe.domain.admin.controller.request.AdminChangePasswordRequest;
import com.example.tempbe.domain.admin.controller.request.AdminLoginRequest;
import com.example.tempbe.domain.admin.controller.request.IssueRequest;
import com.example.tempbe.domain.admin.controller.response.AdminProfileResponse;
import com.example.tempbe.domain.admin.service.AdminChangePasswordService;
import com.example.tempbe.domain.admin.service.AdminIssueService;
import com.example.tempbe.domain.admin.service.AdminLoginService;
import com.example.tempbe.domain.admin.service.AdminProfileService;
import com.example.tempbe.domain.auth.controller.response.TokenResponse;
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
@RequestMapping("/admin")
@RestController
public class AdminController {
    private final AdminLoginService adminLoginService;
    private final AdminIssueService adminIssueService;
    private final AdminProfileService adminProfileService;
    private final AdminChangePasswordService adminChangePasswordService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid AdminLoginRequest request) {
        return adminLoginService.execute(request);
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
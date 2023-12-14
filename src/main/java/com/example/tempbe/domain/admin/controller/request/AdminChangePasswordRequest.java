package com.example.tempbe.domain.admin.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class AdminChangePasswordRequest {
    @NotBlank
    private String password;

    @NotBlank
    private String newPassword;

    @NotBlank
    private String newPasswordCheck;
}

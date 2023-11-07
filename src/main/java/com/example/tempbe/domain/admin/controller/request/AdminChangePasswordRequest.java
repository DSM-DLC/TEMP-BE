package com.example.tempbe.domain.admin.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class AdminChangePasswordRequest {
    @NotNull
    private String password;

    @NotNull
    private String newPassword;

    @NotNull
    private String newPasswordCheck;
}

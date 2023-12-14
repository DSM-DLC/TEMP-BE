package com.example.tempbe.domain.admin.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class AdminLoginRequest {
    @NotBlank(message = "아이디를 입력해주세요.")
    private String adminId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}

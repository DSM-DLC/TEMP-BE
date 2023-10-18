package com.example.tempbe.domain.admin.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class AdminLoginRequest {
    @NotNull(message = "아이디를 입력해주세요.")
    private String adminId;

    @NotNull(message = "비밀번호를 입력해주세요.")
    private String password;
}

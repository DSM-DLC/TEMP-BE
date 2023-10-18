package com.example.tempbe.domain.user.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class UserLoginRequest {
    @NotNull(message = "아이디를 입력해주세요.")
    private String userId;

    @NotNull(message = "비밀번호를 입력해주세요.")
    private String password;
}

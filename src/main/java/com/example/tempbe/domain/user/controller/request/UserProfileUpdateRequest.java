package com.example.tempbe.domain.user.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class UserProfileUpdateRequest {
    @NotNull(message = "아이디를 입력해주세요")
    private String userId;

    @NotNull(message = "이름을 입력해주세요")
    private String name;

    @NotNull(message = "소속 부서를 입력해주세요")
    private String department;

    @NotNull(message = "연락처를 입력해주세요")
    private String contact;
}

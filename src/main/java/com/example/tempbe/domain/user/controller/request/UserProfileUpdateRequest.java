package com.example.tempbe.domain.user.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class UserProfileUpdateRequest {
    @NotBlank(message = "아이디를 입력해주세요")
    private String userId;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @NotBlank(message = "소속 부서를 입력해주세요")
    private String department;

    @NotBlank(message = "연락처를 입력해주세요")
    private String contact;
}

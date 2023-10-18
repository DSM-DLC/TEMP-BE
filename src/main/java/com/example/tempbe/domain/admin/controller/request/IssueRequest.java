package com.example.tempbe.domain.admin.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
public class IssueRequest {
    @NotNull(message = "아이디를 입력해주세요.")
    private String userId;

    @NotNull(message = "이름을 입력해주세요.")
    private String name;

    @NotNull(message = "연락처를 입력해주세요.")
    private String contact;

    @NotNull(message = "부서를 입력해주세요.")
    private String department;

    @NotNull(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자가 포함되어야 합니다.")
    private String password;

    @NotNull(message = "역할을 입력해주세요.")
    private String role;
}

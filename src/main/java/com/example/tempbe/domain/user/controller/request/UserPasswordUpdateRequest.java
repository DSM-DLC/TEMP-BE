package com.example.tempbe.domain.user.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class UserPasswordUpdateRequest {
    @NotNull
    private String password;
}

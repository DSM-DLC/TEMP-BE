package com.example.tempbe.domain.info.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class InfoDetailRequest {
    @NotNull
    private String name;

    @NotNull
    private String birthDate;

    @NotNull
    private String address;
}

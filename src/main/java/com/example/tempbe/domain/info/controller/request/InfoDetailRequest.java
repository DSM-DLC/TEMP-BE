package com.example.tempbe.domain.info.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
public class InfoDetailRequest {
    @NotNull
    private String name;

    @NotNull
    private Date birthDate;

    @NotNull
    private String address;
}

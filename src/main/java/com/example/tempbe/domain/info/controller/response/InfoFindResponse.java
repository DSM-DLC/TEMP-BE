package com.example.tempbe.domain.info.controller.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class InfoFindResponse {
    private final String name;

    private final Date birthDate;

    private final String address;
}

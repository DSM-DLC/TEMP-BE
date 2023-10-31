package com.example.tempbe.domain.info.controller.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InfoFindResponse {
    private final String name;

    private final String birthDate;

    private final String address;
}

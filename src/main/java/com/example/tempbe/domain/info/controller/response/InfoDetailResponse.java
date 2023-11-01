package com.example.tempbe.domain.info.controller.response;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class InfoDetailResponse {
    private final String name;

    private final String birthDate;

    private final String address;

    private final String budgetBasis;

    private final Long cost;

    private final Long workHour;

    private final Boolean fourInsurance;

    private final String jobType;

    private final String period;

    private final String issuanceDepartment;

    private final String picName;

    private final String picContact;
}

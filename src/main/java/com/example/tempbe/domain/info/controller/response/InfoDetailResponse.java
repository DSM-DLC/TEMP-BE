package com.example.tempbe.domain.info.controller.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
public class InfoDetailResponse {
    private final UUID id;

    private final String name;

    private final Date birthDate;

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

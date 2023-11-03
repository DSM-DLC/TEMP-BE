package com.example.tempbe.domain.info.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class InfoUpdateRequest {
    @NotNull
    private UUID id;

    @NotNull(message = "성명을 입력해주세요")
    private String name;

    @NotNull(message = "생년월일을 입력해주세요")
    private Date birthDate;

    @NotNull(message = "주소를 입력해주세요")
    private String address;

    @NotNull(message = "예산근거를 입력해주세요")
    private String budgetBasis;

    @NotNull(message = "총인권비를 입력해주세요")
    private Long cost;

    @NotNull(message = "근로시간을 입력해주세요")
    private Long workHour;

    @NotNull
    private Boolean fourInsurance;

    @NotNull(message = "직종을 입력해주세요")
    private String jobType;

    @NotNull(message = "재직기간을 입력해주세요")
    private String period;

    @NotNull(message = "발급부서를 입력해주세요")
    private String issuanceDepartment;

    @NotNull(message = "담당자 이름을 입력해주세요")
    private String picName;

    @NotNull(message = "담당자 연락처를 입력해주세요")
    private String picContact;
}

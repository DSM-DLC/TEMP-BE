package com.example.tempbe.domain.info.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class InfoUpdateRequest {
    @NotNull
    private UUID id;

    @NotBlank(message = "성명을 입력해주세요")
    private String name;

    @NotNull(message = "생년월일을 입력해주세요")
    private String birthDate;

    @NotBlank(message = "주소를 입력해주세요")
    private String address;

    @NotBlank(message = "예산근거를 입력해주세요")
    private String budgetBasis;

    private Long cost;

    @NotNull(message = "근로시간을 입력해주세요")
    private Long workHour;

    private Boolean fourInsurance;

    @NotBlank(message = "비고를 입력해주세요")
    private String jobType;

    @NotBlank(message = "재직기간을 입력해주세요")
    private String period;

    @NotBlank(message = "발급부서를 입력해주세요")
    private String issuanceDepartment;

    @NotBlank(message = "담당자 이름을 입력해주세요")
    private String picName;

    @NotBlank(message = "담당자 연락처를 입력해주세요")
    private String picContact;
}

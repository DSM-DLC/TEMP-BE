package com.example.tempbe.domain.info.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
public class InfoFindRequest {
    @NotNull(message = "성명을 입력해주세요")
    private String name;

    private Date birthDate;
}

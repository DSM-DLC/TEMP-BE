package com.example.tempbe.domain.info.domain;

import com.example.tempbe.global.entity.BaseIdEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Info extends BaseIdEntity {
    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String birthDate;

    @Column(nullable = false, length = 30)
    private String address;

    @Column(nullable = false, length = 200)
    private String budgetBasis;

    @NotNull
    private Long cost;

    @NotNull
    private Long workHour;

    @NotNull
    private Boolean fourInsurance;

    @Column(nullable = false, length = 20)
    private String jobType;

    @Column(nullable = false, length = 50)
    private String period;

    @Column(nullable = false, length = 20)
    private String issuanceDepartment;

    @Column(nullable = false, length = 20)
    private String picName;

    @Column(nullable = false, length = 20)
    private String picContact;

    @Builder
    public Info(String name, String birthDate, String address, String budgetBasis, Long cost, Long workHour, Boolean fourInsurance,
                String jobType, String period, String issuanceDepartment, String picName, String picContact){
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.budgetBasis = budgetBasis;
        this.cost = cost;
        this.workHour = workHour;
        this.fourInsurance = fourInsurance;
        this.jobType = jobType;
        this.period = period;
        this.issuanceDepartment = issuanceDepartment;
        this.picName = picName;
        this.picContact = picContact;
    }

    public void updateInfo(String name, String birthDate, String address, String budgetBasis, Long cost, Long workHour, Boolean fourInsurance,
                           String jobType, String period, String issuanceDepartment, String picName, String picContact){
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.budgetBasis = budgetBasis;
        this.cost = cost;
        this.workHour = workHour;
        this.fourInsurance = fourInsurance;
        this.jobType = jobType;
        this.period = period;
        this.issuanceDepartment = issuanceDepartment;
        this.picName = picName;
        this.picContact = picContact;
    }
}

package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.response.InfoDetailResponse;
import com.example.tempbe.domain.info.domain.Info;
import com.example.tempbe.domain.info.domain.InfoRepository;
import com.example.tempbe.domain.info.exception.InfoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class InfoDetailService {
    private final InfoRepository infoRepository;

    @Transactional(readOnly = true)
    public InfoDetailResponse execute(String name, Date birthDate, String address){
        Info info = infoRepository.findByNameAndBirthDateAndAddress(name, birthDate, address)
                .orElseThrow(()-> InfoNotFoundException.EXCEPTION);

        return InfoDetailResponse.builder()
                .id(info.getId())
                .name(info.getName())
                .birthDate(info.getBirthDate())
                .address(info.getAddress())
                .budgetBasis(info.getBudgetBasis())
                .cost(info.getCost())
                .workHour(info.getWorkHour())
                .fourInsurance(info.getFourInsurance())
                .jobType(info.getJobType())
                .period(info.getPeriod())
                .issuanceDepartment(info.getIssuanceDepartment())
                .picName(info.getPicName())
                .picContact(info.getPicContact())
                .build();
    }
}

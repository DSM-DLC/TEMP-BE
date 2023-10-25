package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.request.InfoUploadRequest;
import com.example.tempbe.domain.info.domain.Info;
import com.example.tempbe.domain.info.domain.InfoRepository;
import com.example.tempbe.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class InfoUploadService {
    private final InfoRepository infoRepository;
    private final UserRepository userRepository;

    @Transactional
    public void execute(InfoUploadRequest request){
        infoRepository.save(Info.builder()
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .address(request.getAddress())
                .budgetBasis(request.getBudgetBasis())
                .cost(request.getCost())
                .workHour(request.getWorkHour())
                .fourInsurance(request.getFourInsurance())
                .jobType(request.getJobType())
                .period(request.getPeriod())
                .issuanceDepartment(request.getIssuanceDepartment())
                .picName(request.getPicName())
                .picContact(request.getPicContact())
                .build());
    }
}
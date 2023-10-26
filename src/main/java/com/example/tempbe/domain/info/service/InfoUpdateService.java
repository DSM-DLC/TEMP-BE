package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.request.InfoUpdateRequest;
import com.example.tempbe.domain.info.domain.Info;
import com.example.tempbe.domain.info.domain.InfoRepository;
import com.example.tempbe.domain.info.exception.InfoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InfoUpdateService {
    private final InfoRepository infoRepository;

    @Transactional
    public void execute(InfoUpdateRequest request){
        Info info = infoRepository.findByNameAndBirthDate(request.getName(), request.getBirthDate())
                .orElseThrow(()-> InfoNotFoundException.EXCEPTION);

        info.updateInfo(request.getName(),
                request.getBirthDate(),
                request.getAddress(),
                request.getBudgetBasis(),
                request.getCost(),
                request.getWorkHour(),
                request.getFourInsurance(),
                request.getJobType(),
                request.getPeriod(),
                request.getIssuanceDepartment(),
                request.getPicName(),
                request.getPicContact());

        infoRepository.save(info);
    }
}
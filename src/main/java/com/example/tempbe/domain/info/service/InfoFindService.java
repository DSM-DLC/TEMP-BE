package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.request.InfoFindRequest;
import com.example.tempbe.domain.info.controller.response.InfoFindResponse;
import com.example.tempbe.domain.info.domain.Info;
import com.example.tempbe.domain.info.domain.InfoRepository;
import com.example.tempbe.domain.info.exception.InfoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InfoFindService {
    private final InfoRepository infoRepository;

    @Transactional(readOnly = true)
    public InfoFindResponse execute(InfoFindRequest request){
        Info info = infoRepository.findByNameAndBirthDate(request.getName(), request.getBirthDate())
                .orElseThrow(()-> InfoNotFoundException.EXCEPTION);

        return InfoFindResponse.builder()
                .name(info.getName())
                .birthDate(info.getBirthDate())
                .address(info.getAddress())
                .build();
    }
}

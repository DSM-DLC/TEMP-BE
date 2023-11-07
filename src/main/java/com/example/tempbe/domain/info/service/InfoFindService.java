package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.response.InfoFindResponse;
import com.example.tempbe.domain.info.domain.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InfoFindService {
    private final InfoRepository infoRepository;

    @Transactional(readOnly = true)
    public List<InfoFindResponse> execute(String name, Date birthDate){
        if(birthDate == null) {
            List<InfoFindResponse> infoFindResponseList = infoRepository.findByName(name)
                    .stream().map(info -> InfoFindResponse
                            .builder()
                            .name(info.getName())
                            .birthDate(info.getBirthDate())
                            .address(info.getAddress())
                            .build())
                    .collect(Collectors.toList());

            return infoFindResponseList;
        }

        List<InfoFindResponse> infoFindResponseList = infoRepository.findByNameAndBirthDate(name, birthDate)
                .stream().map(info -> InfoFindResponse
                        .builder()
                        .name(info.getName())
                        .birthDate(info.getBirthDate())
                        .address(info.getAddress())
                        .build())
                .collect(Collectors.toList());

        return infoFindResponseList;
    }
}

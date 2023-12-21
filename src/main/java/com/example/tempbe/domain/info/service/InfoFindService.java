package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.response.FindResponse;
import com.example.tempbe.domain.info.controller.response.InfoFindResponse;
import com.example.tempbe.domain.info.domain.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InfoFindService {
    private final InfoRepository infoRepository;

    @Transactional(readOnly = true)
    public FindResponse execute(Pageable pageable, String name, String birthDate){
        if(name.isEmpty()){
            Page<InfoFindResponse> page = infoRepository.findAll(pageable)
                    .map(InfoFindResponse::from);

            return FindResponse.builder()
                    .contents(page.getContent())
                    .count(page.getTotalElements())
                    .build();
        }
        else if(birthDate == null) {
            Page<InfoFindResponse> page = infoRepository.findByNameContaining(pageable, name)
                    .map(InfoFindResponse::from);

            return FindResponse.builder()
                    .contents(page.getContent())
                    .count(page.getTotalElements())
                    .build();
        }

        Page<InfoFindResponse> page = infoRepository.findByNameContainingAndBirthDate(pageable, name, birthDate + "******")
                .map(InfoFindResponse::from);

        return FindResponse.builder()
                .contents(page.getContent())
                .count(page.getTotalElements())
                .build();
    }
}

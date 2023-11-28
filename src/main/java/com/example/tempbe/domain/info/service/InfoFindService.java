package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.response.FindResponse;
import com.example.tempbe.domain.info.controller.response.InfoFindResponse;
import com.example.tempbe.domain.info.domain.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public FindResponse execute(Pageable pageable, String name, Date birthDate){
        if(birthDate == null) {
            Page<InfoFindResponse> page = infoRepository.findByName(pageable, name)
                    .map(InfoFindResponse::from);

            return FindResponse.builder()
                    .contents(page.getContent())
                    .count(page.getTotalElements())
                    .build();
        }

        Page<InfoFindResponse> page = infoRepository.findByNameAndBirthDate(pageable, name, birthDate)
                .map(InfoFindResponse::from);

        return FindResponse.builder()
                .contents(page.getContent())
                .count(page.getTotalElements())
                .build();
    }
}

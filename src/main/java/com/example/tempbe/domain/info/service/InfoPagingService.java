package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.response.InfoPagingResponse;
import com.example.tempbe.domain.info.controller.response.PageResponse;
import com.example.tempbe.domain.info.domain.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class InfoPagingService {
    private final InfoRepository infoRepository;

    @Transactional(readOnly = true)
    public PageResponse findAll(Pageable pageable){
        Page<InfoPagingResponse> page = infoRepository.findAll(pageable)
                .map(InfoPagingResponse::from);

        return PageResponse.builder()
                .contents(page.getContent())
                .count(page.getTotalElements())
                .build();
    }
}

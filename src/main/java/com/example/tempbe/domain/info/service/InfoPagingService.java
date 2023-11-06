package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.response.InfoPagingResponse;
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
    public Page<InfoPagingResponse> findAll(Pageable pageable){
        return infoRepository.findAll(pageable)
                .map(InfoPagingResponse::from);
    }
}

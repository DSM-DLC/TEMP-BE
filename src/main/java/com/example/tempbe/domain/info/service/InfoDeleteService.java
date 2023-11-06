package com.example.tempbe.domain.info.service;

import com.example.tempbe.domain.info.controller.request.InfoDeleteRequest;
import com.example.tempbe.domain.info.domain.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class InfoDeleteService {
    private final InfoRepository infoRepository;

    @Transactional
    public void execute(InfoDeleteRequest request){
        infoRepository.deleteById(request.getId());
    }
}

package com.example.tempbe.domain.info.controller;

import com.example.tempbe.domain.info.controller.request.InfoUploadRequest;
import com.example.tempbe.domain.info.service.InfoUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
    private final InfoUploadService infoUploadService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload")
    public void upload(@RequestBody @Valid InfoUploadRequest request){
        infoUploadService.execute(request);
    }
}
package com.example.tempbe.domain.info.controller;

import com.example.tempbe.domain.info.controller.request.InfoDeleteRequest;
import com.example.tempbe.domain.info.controller.request.InfoUpdateRequest;
import com.example.tempbe.domain.info.controller.request.InfoUploadRequest;
import com.example.tempbe.domain.info.controller.response.*;
import com.example.tempbe.domain.info.service.InfoDeleteService;
import com.example.tempbe.domain.info.service.InfoDetailService;
import com.example.tempbe.domain.info.service.InfoFindService;
import com.example.tempbe.domain.info.service.InfoUpdateService;
import com.example.tempbe.domain.info.service.InfoUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
    private final InfoUploadService infoUploadService;
    private final InfoUpdateService infoUpdateService;
    private final InfoFindService infoFindService;
    private final InfoDetailService infoDetailService;
    private final InfoDeleteService infoDeleteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload")
    public void upload(@RequestBody @Valid InfoUploadRequest request){
        infoUploadService.execute(request);
    }

    @PatchMapping("/update")
    public void update(@RequestBody @Valid InfoUpdateRequest request){
        infoUpdateService.execute(request);
    }

    @GetMapping("/find")
    public FindResponse find(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam String name,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthDate
    ){
        return infoFindService.execute(pageable ,name, birthDate);
    }

    @GetMapping("/detail")
    public InfoDetailResponse detail(
            @RequestParam String name,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthDate,
            @RequestParam String address
    ){
        return infoDetailService.execute(name, birthDate, address);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid InfoDeleteRequest request){
        infoDeleteService.execute(request);
    }

}
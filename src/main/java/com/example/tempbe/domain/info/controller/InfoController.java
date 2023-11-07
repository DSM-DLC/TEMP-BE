package com.example.tempbe.domain.info.controller;

import com.example.tempbe.domain.info.controller.request.*;
import com.example.tempbe.domain.info.controller.response.InfoDetailResponse;
import com.example.tempbe.domain.info.controller.response.InfoFindResponse;
import com.example.tempbe.domain.info.controller.response.InfoPagingResponse;
import com.example.tempbe.domain.info.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
    private final InfoUploadService infoUploadService;
    private final InfoUpdateService infoUpdateService;
    private final InfoFindService infoFindService;
    private final InfoDetailService infoDetailService;
    private final InfoPagingService infoPagingService;
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
    public List<InfoFindResponse> find(
            @RequestParam String name,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthDate
    ){
        return infoFindService.execute(name, birthDate);
    }

    @GetMapping("/detail")
    public InfoDetailResponse detail(
            @RequestParam String name,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthDate,
            @RequestParam String address
    ){
        return infoDetailService.execute(name, birthDate, address);
    }

    @GetMapping("/list")
    public List<InfoPagingResponse> find(Pageable pageable){
        return infoPagingService.findAll(pageable).getContent();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Valid InfoDeleteRequest request){
        infoDeleteService.execute(request);
    }

}
package com.example.tempbe.domain.info.controller;

import com.example.tempbe.domain.info.controller.request.InfoDetailRequest;
import com.example.tempbe.domain.info.controller.request.InfoFindRequest;
import com.example.tempbe.domain.info.controller.request.InfoUpdateRequest;
import com.example.tempbe.domain.info.controller.request.InfoUploadRequest;
import com.example.tempbe.domain.info.controller.response.InfoDetailResponse;
import com.example.tempbe.domain.info.controller.response.InfoFindResponse;
import com.example.tempbe.domain.info.service.InfoDetailService;
import com.example.tempbe.domain.info.service.InfoUpdateService;
import com.example.tempbe.domain.info.service.InfoUploadService;
import com.example.tempbe.domain.info.service.InfoFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
    private final InfoUploadService infoUploadService;
    private final InfoUpdateService infoUpdateService;
    private final InfoFindService infoFindService;
    private final InfoDetailService infoDetailService;

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
    public List<InfoFindResponse> find(@RequestBody @Valid InfoFindRequest request){
        return infoFindService.execute(request);
    }

    @GetMapping("/detail")
    public InfoDetailResponse find(@RequestBody @Valid InfoDetailRequest request){
        return infoDetailService.execute(request);
    }
}
package com.example.tempbe.domain.info.controller.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageResponse {
    private final List<InfoPagingResponse> contents;
    private final Long count;
}

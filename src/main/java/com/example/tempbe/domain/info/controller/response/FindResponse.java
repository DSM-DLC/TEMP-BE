package com.example.tempbe.domain.info.controller.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FindResponse {
    private final List<InfoFindResponse> contents;
    private final Long count;
}

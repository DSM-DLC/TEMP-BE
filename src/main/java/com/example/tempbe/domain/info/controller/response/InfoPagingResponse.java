package com.example.tempbe.domain.info.controller.response;

import com.example.tempbe.domain.info.domain.Info;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class InfoPagingResponse {
    private final String name;

    private final Date birthDate;

    private final String address;

    public static InfoPagingResponse from(Info info){
        return InfoPagingResponse.builder()
                .name(info.getName())
                .birthDate(info.getBirthDate())
                .address(info.getAddress())
                .build();
    }
}

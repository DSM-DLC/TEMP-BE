package com.example.tempbe.domain.info.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class InfoDeleteRequest {
    @NotNull
    private UUID id;
}


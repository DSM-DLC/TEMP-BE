package com.example.tempbe.domain.user.controller.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserProfileResponse {
    private final String userId;

    private final String name;

    private final String department;

    private final String contact;
}

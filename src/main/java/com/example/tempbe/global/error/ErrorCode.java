package com.example.tempbe.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    ADMIN_NOT_FOUND(404, "관리자를 찾을 수 없습니다."),
    NOT_MATCHES_PASSWORD(400, "비밀번호가 올바르지 않습니다."),

    EXPIRED_JWT(401, "토큰이 만료되었습니다."),
    INVALID_JWT(401, "토큰이 유효하지 않습니다."),

    NOT_REFRESH_TOKEN(401,"refresh 토큰이 아닙니다."),
    NOT_FOUND_REFRESH_TOKEN(404, "refresh 토큰을 찾을 수 없습니다.");

    private final int status;
    private final String message;
}

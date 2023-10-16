package com.example.tempbe.global.error.handler;

import com.example.tempbe.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BaseException extends RuntimeException {
    private final ErrorCode errorCode;
}

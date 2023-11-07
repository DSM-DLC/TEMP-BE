package com.example.tempbe.domain.auth.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class NotMatchesNewPasswordException extends BaseException {

    public static final BaseException EXCEPTION = new NotMatchesNewPasswordException();

    private NotMatchesNewPasswordException() {
        super(ErrorCode.NOT_MATCHES_PASSWORD);
    }
}
package com.example.tempbe.domain.auth.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class NotMatchesPasswordException extends BaseException {

    public static final BaseException EXCEPTION = new NotMatchesPasswordException();

    private NotMatchesPasswordException() {
        super(ErrorCode.NOT_MATCHES_PASSWORD);
    }
}
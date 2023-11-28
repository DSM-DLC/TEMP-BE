package com.example.tempbe.domain.auth.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class PasswordMisMatchException extends BaseException {

    public static final BaseException EXCEPTION = new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }
}
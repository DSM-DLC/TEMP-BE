package com.example.tempbe.domain.auth.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class NewPasswordMisMatchException extends BaseException {

    public static final BaseException EXCEPTION = new NewPasswordMisMatchException();

    private NewPasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }
}
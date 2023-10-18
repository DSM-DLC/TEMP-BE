package com.example.tempbe.global.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class ExpiredTokenException extends BaseException{
    public static final BaseException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}

package com.example.tempbe.global.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class InvalidTokenException extends BaseException {
    public static final BaseException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_JWT);
    }
}

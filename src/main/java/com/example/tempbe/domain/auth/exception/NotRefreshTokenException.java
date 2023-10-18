package com.example.tempbe.domain.auth.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class NotRefreshTokenException extends BaseException {

    public final static NotRefreshTokenException EXCEPTION = new NotRefreshTokenException();

    public NotRefreshTokenException() {
        super(ErrorCode.NOT_REFRESH_TOKEN);
    }
}

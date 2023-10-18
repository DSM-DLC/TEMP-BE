package com.example.tempbe.domain.auth.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class NotFoundRefreshTokenException extends BaseException {

    public final static NotFoundRefreshTokenException EXCEPTION = new NotFoundRefreshTokenException();

    public NotFoundRefreshTokenException() {
        super(ErrorCode.NOT_FOUND_REFRESH_TOKEN);
    }
}

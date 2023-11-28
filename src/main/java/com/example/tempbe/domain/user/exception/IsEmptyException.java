package com.example.tempbe.domain.user.exception;

import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class IsEmptyException extends BaseException {
    public static final BaseException EXCEPTION = new IsEmptyException();

    public IsEmptyException() {
        super(ErrorCode.IS_EMPTY);
    }
}

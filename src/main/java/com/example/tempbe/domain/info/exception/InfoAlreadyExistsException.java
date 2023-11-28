package com.example.tempbe.domain.info.exception;

import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class InfoAlreadyExistsException extends BaseException {
    public static final BaseException EXCEPTION = new InfoAlreadyExistsException();

    public InfoAlreadyExistsException() {
        super(ErrorCode.INFO_ALREADY_EXISTS);
    }
}

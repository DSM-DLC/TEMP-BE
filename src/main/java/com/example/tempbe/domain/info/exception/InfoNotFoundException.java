package com.example.tempbe.domain.info.exception;

import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class InfoNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new InfoNotFoundException();

    public InfoNotFoundException() {
        super(ErrorCode.INFO_NOT_FOUND);
    }
}
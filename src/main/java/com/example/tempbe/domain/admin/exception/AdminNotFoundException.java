package com.example.tempbe.domain.admin.exception;


import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class AdminNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new AdminNotFoundException();

    private AdminNotFoundException() {
        super(ErrorCode.ADMIN_NOT_FOUND);
    }
}

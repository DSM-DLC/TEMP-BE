package com.example.tempbe.domain.admin.exception;

import com.example.tempbe.global.error.ErrorCode;
import com.example.tempbe.global.error.handler.BaseException;

public class IssueAlreadyExistsException extends BaseException {
    public static final BaseException EXCEPTION = new IssueAlreadyExistsException();

    private IssueAlreadyExistsException() {
        super(ErrorCode.ISSUE_ALREADY_EXISTS);
    }
}

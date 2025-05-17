package com.global.aws.exception;

import com.global.apiPayload.exception.GeneralException;
import com.global.apiPayload.exception.code.BaseErrorCode;

public class S3Exception extends GeneralException {
    public S3Exception(BaseErrorCode code) {
        super(code);
    }
}

package com.example.sustainableFashion.global.aws.exception;

import com.example.sustainableFashion.global.apiPayload.exception.GeneralException;
import com.example.sustainableFashion.global.apiPayload.exception.code.BaseErrorCode;

public class S3Exception extends GeneralException {
    public S3Exception(BaseErrorCode code) {
        super(code);
    }
}

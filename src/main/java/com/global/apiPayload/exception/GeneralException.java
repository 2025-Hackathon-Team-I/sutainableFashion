package com.global.apiPayload.exception;

import com.global.apiPayload.exception.code.BaseErrorCode;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException {
    private final BaseErrorCode code;
    public GeneralException(BaseErrorCode code) {
        this.code = code;
    }
}

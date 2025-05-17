package com.global.apiPayload.exception.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseCode{

    OK(HttpStatus.OK,
            "COMMON200",
            "성공적으로 요청을 완료했습니다."),
    CREATED(HttpStatus.CREATED,
            "COMMON201",
            "성공적으로 생성했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}

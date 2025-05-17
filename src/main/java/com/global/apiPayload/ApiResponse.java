package com.global.apiPayload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.global.apiPayload.exception.code.GeneralSuccessCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final boolean isSuccess;

    @JsonProperty("code")
    private final String code;

    @JsonProperty("message")
    private final String message;

    @JsonProperty("result")
    private T result;

    public static <T> ApiResponse<T> ok(T result) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK.getCode(),
                GeneralSuccessCode.OK.getMessage(),
                result
        );
    }

    public static <T> ApiResponse<T> created(T result) {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.CREATED.getCode(),
                GeneralSuccessCode.CREATED.getMessage(),
                result
        );
    }

    public static <T> ApiResponse<T> onSuccess(String code, String message, T result) {
        return new ApiResponse<>(true, code, message, result);
    }

    public static <T> ApiResponse<T> onFailure(String code, String message) {
        return onFailure(code, message, null);
    }

    // 실패시 result는 null로 반환
    public static <T> ApiResponse<T> onFailure(String code, String message, T result) {
        return new ApiResponse<>(false, code, message, result);
    }
}

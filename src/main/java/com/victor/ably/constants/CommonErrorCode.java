package com.victor.ably.constants;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Getter
@ToString
public enum CommonErrorCode {

    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0003"),
    EMPTY_SESSION(HttpStatus.UNAUTHORIZED, "CE0001", "로그인이 필요합니다");

    private final HttpStatus status;
    private final String code;
    private String message;

    CommonErrorCode(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    CommonErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}

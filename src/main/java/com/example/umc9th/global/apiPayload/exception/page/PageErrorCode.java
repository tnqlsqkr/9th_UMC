package com.example.umc9th.global.apiPayload.exception.page;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PageErrorCode implements BaseErrorCode {

    PAGE_OUT_OF_RANGE(HttpStatus.BAD_REQUEST, "PAGE400-1", "유효하지 않은 페이지 번호입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

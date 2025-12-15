package com.example.umc9th.domain.review.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {

    INVALID_SEARCH_TYPE(HttpStatus.BAD_REQUEST, "REVIEW400-1", "잘못된 검색 타입입니다."),
    INVALID_QUERY_FORMAT(HttpStatus.BAD_REQUEST, "REVIEW400-2", "검색 쿼리 형식이 올바르지 않습니다."),
    NOT_FOUND_REVIEW(HttpStatus.NOT_FOUND, "REVIEW404-1", "해당 조건을 만족하는 리뷰가 존재하지 않습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

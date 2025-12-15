package com.example.umc9th.domain.member.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404-1", "해당 사용자를 찾지 못했습니다."),
    INVALID(HttpStatus.BAD_REQUEST, "MEMBER400-1", "잘못된 회원 요청입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

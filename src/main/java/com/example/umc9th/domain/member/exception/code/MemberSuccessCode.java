package com.example.umc9th.domain.member.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {

    MEMBER_FOUND(HttpStatus.OK, "MEMBER200-1", "성공적으로 사용자를 조회했습니다."),
    MEMBER_OK(HttpStatus.OK, "MEMBER200-2", "성공적으로 사용자의 미션을 조회했습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

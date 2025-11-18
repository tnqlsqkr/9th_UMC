package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode  {

    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION404-1", "해당 조건을 만족하는 미션이 존재하지 않습니다."),
    ALREADY_CHALLENGING(HttpStatus.CONFLICT, "MISSION409-1", "이미 도전 중인 미션입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

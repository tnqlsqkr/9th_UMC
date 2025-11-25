package com.example.umc9th.domain.member.dto.res;

import com.example.umc9th.domain.mission.enums.MissionStatus;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResDTO {

    @Builder
    public record JoinDTO(
            Long memberId,
            LocalDateTime createdAt
    ) {}

    @Builder
    public record MemberMissionListDTO(
            List<MemberMissionDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record MemberMissionDTO(
        String storeName,
        String content,
        LocalDate deadline,
        int point,
        MissionStatus status,
        Boolean isSuccess
    ){}
}

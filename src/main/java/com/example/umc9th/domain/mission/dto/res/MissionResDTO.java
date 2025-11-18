package com.example.umc9th.domain.mission.dto.res;

import com.example.umc9th.domain.member.enums.MissionStatus;

import java.time.LocalDateTime;

public class MissionResDTO {

    public record ChallengeResponse(
            Long id,
            Long missionId,
            String storeName,
            String memberName,
            MissionStatus status,
            LocalDateTime createdAt
    ) {}
}

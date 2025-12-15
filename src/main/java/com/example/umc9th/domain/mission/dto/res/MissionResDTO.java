package com.example.umc9th.domain.mission.dto.res;

import com.example.umc9th.domain.mission.enums.MissionStatus;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {

    public record ChallengeResponse(
            Long id,
            Long missionId,
            String storeName,
            String memberName,
            MissionStatus status,
            LocalDateTime createdAt
    ) {}

    @Builder
    public record StoreMissionListDTO(
            List<StoreMissionDTO> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record StoreMissionDTO(
            String storeName,
            String content,
            LocalDate deadline,
            int point
    ){}
}

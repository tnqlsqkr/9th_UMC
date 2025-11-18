package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

public interface MissionCommandService {

    MissionResDTO.ChallengeResponse challengeMission(Long missionId, Long memberId);
}

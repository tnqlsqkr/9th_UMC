package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/{missionId}/challenge/{memberId}")
    ApiResponse<MissionResDTO.ChallengeResponse> challengeMission(
            @PathVariable Long missionId,
            @PathVariable Long memberId
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED_201, missionCommandService.challengeMission(missionId, memberId));
    }
}

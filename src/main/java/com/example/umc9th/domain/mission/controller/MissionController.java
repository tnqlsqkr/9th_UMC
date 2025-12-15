package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.domain.mission.service.query.MissionQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
@Validated
public class MissionController implements MissionControllerDocs {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

    @PostMapping("/{missionId}/challenge/{memberId}")
    ApiResponse<MissionResDTO.ChallengeResponse> challengeMission(
            @PathVariable Long missionId,
            @PathVariable Long memberId
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED_201, missionCommandService.challengeMission(missionId, memberId));
    }

    @GetMapping("/store/{storeId}")
    @Override
    public ApiResponse<MissionResDTO.StoreMissionListDTO> getMissions(
            @PathVariable Long storeId,
            @RequestParam(defaultValue = "1") Integer page
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK_200, missionQueryService.findMissions(storeId, page));
    }
}

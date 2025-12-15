package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Min;

public interface MissionControllerDocs {

    @Operation(summary = "특정 가게의 미션 목록 조회 API", description = "특정 가게에 존재하는 리뷰를 모두 조회합니다. 페이지네이션으로 제공합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MissionResDTO.StoreMissionListDTO> getMissions(
            Long storeId,
            @Min(value = 1, message = "page는 1 이상이어야 합니다.") Integer page
    );
}

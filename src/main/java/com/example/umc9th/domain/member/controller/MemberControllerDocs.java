package com.example.umc9th.domain.member.controller;

import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Min;

public interface MemberControllerDocs {

    @Operation(summary = "특정 member가 진행중인 미션 목록 조회 API", description = "특정 member의 진행중인 미션을 모두 조회합니다. 페이지네이션으로 제공합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MemberResDTO.MemberMissionListDTO> getActiveMissions(
            Long memberId,
            @Min(value = 1, message = "page는 1 이상이어야 합니다.") Integer page
    );
}

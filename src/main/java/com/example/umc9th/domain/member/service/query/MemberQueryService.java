package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import jakarta.validation.Valid;

public interface MemberQueryService {
    MemberResDTO.MemberMissionListDTO findActiveMissions(Long memberId, Integer page);

    MemberResDTO.LoginDTO login(MemberReqDTO.@Valid LoginDTO dto);
}

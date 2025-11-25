package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.dto.res.MemberResDTO;

public interface MemberQueryService {
    MemberResDTO.MemberMissionListDTO findActiveMissions(Long memberId, Integer page);
}

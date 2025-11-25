package com.example.umc9th.domain.member.service.query;

import com.example.umc9th.domain.member.converter.MemberMissionConverter;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberMissionRepository;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.global.apiPayload.exception.page.PageErrorCode;
import com.example.umc9th.global.apiPayload.exception.page.PageException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public MemberResDTO.MemberMissionListDTO findActiveMissions(Long memberId, Integer page){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        if(page == null || page < 1){
            throw new PageException(PageErrorCode.PAGE_OUT_OF_RANGE);
        }

        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<MemberMission> result = memberMissionRepository.findAllByMemberAndStatus(member, MissionStatus.ONGOING, pageRequest);

        return MemberMissionConverter.toMemberMissionListDTO(result);
    }
}

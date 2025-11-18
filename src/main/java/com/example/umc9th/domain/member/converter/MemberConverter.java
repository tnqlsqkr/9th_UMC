package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.req.MemberReqDTO;
import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;

public class MemberConverter {

    public static MemberResDTO.JoinDTO toJoinDTO(Member member) {
        return MemberResDTO.JoinDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberReqDTO.JoinDTO joinDTO) {
        return Member.builder()
                .name(joinDTO.name())
                .gender(joinDTO.gender())
                .birth(joinDTO.birth())
                .email(joinDTO.email())
                .address(joinDTO.address())
                .phoneNum(joinDTO.phoneNum())
                .build();
    }
}

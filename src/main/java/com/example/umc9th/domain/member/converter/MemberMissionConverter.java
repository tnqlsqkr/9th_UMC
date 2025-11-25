package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.res.MemberResDTO;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MemberMissionConverter {

    public static MemberResDTO.MemberMissionListDTO toMemberMissionListDTO(
            Page<MemberMission> result
    ){
        return MemberResDTO.MemberMissionListDTO.builder()
                .missionList(result.getContent().stream()
                        .map(MemberMissionConverter::toMemberMissionDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static MemberResDTO.MemberMissionDTO toMemberMissionDTO(
            MemberMission memberMission
    ){
        Mission mission = memberMission.getMission();

        return MemberResDTO.MemberMissionDTO.builder()
                .storeName(mission.getStore().getName())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .point(mission.getPoint())
                .status(memberMission.getStatus())
                .isSuccess(memberMission.isSuccess())
                .build();
    }
}

package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MissionConverter {

    public static MemberMission toMissionChallenge(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.ONGOING)
                .isSuccess(false)
                .build();
    }

    public static MissionResDTO.ChallengeResponse toChallengeResponse(MemberMission memberMission){
        return new MissionResDTO.ChallengeResponse(
                memberMission.getId(),
                memberMission.getMission().getId(),
                memberMission.getMission().getStore().getName(),
                memberMission.getMember().getName(),
                memberMission.getStatus(),
                memberMission.getCreatedAt()
        );
    }

    public static MissionResDTO.StoreMissionListDTO toStoreMissionListDTO(
            Page<Mission> result
    ){
        return MissionResDTO.StoreMissionListDTO.builder()
                .missionList(result.getContent().stream()
                        .map(MissionConverter::toStoreMissionDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static MissionResDTO.StoreMissionDTO toStoreMissionDTO(
            Mission mission
    ){
        return MissionResDTO.StoreMissionDTO.builder()
                .storeName(mission.getStore().getName())
                .content(mission.getContent())
                .deadline(mission.getDeadline())
                .point(mission.getPoint())
                .build();
    }
}

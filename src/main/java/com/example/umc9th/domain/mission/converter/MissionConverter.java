package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.enums.MissionStatus;
import com.example.umc9th.domain.mission.dto.res.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;

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
}

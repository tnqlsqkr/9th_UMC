package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.mapping.MemberMission;
import com.example.umc9th.domain.member.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findAllByMemberIdAndStatus(
            Long memberId,
            MissionStatus status,
            Pageable pageable
    );

    List<MemberMission> findAllByMemberId(Long memberId);

    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}

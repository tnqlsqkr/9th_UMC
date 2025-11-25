package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
        SELECT m FROM Mission m
        WHERE m.store.location = :location
          AND m.deadline >= :today
          AND m.id NOT IN (
              SELECT mm.mission.id FROM MemberMission mm
              WHERE mm.member.id = :memberId
          )
        """)
    List<Mission> findAvailableMissions(
            @Param("memberId") Long memberId,
            @Param("location") String location,
            @Param("today") LocalDate today,
            Pageable pageable
    );

    Page<Mission> findAllByStore(Store store, Pageable pageable);
}

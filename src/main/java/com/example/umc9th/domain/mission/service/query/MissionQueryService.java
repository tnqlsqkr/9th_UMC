package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.res.MissionResDTO;

public interface MissionQueryService {
    MissionResDTO.StoreMissionListDTO findMissions(Long storeId, Integer page);
}

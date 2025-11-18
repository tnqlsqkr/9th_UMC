package com.example.umc9th.domain.member.dto.req;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.global.annotation.ExistFoods;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {

    public record JoinDTO(
            String name,
            Gender gender,
            LocalDate birth,
            String email,
            String address,
            String phoneNum,
            @ExistFoods
            List<Long> memberFoodList
    ){}
}

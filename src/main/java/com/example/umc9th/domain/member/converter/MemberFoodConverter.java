package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.food.entity.Food;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.entity.mapping.MemberFood;

public class MemberFoodConverter {

    public static MemberFood toMemberFood(Member member, Food food) {
        return MemberFood.builder()
                .member(member)
                .food(food)
                .build();
    }
}

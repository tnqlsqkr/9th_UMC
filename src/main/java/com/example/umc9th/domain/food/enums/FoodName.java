package com.example.umc9th.domain.food.enums;

import lombok.Getter;

@Getter
public enum FoodName {
    CHINESE("중식"),
    KOREAN("한식"),
    JAPANESE("일식"),
    WESTERN("양식"),
    CHICKEN("치킨"),
    SNACK("분식"),
    GRILL("고기/구이"),
    LUNCHBOX("도시락"),
    LATE_NIGHT("야식");

    private final String koreanName;

    FoodName(String koreanName) {
        this.koreanName = koreanName;
    }
}

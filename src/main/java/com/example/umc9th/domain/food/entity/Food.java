package com.example.umc9th.domain.food.entity;

import com.example.umc9th.domain.food.enums.FoodName;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@Table(name = "food")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private FoodName name;

}

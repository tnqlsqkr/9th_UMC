package com.example.umc9th.domain.review.dto.res;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReviewResDTO {

    public record searchReviewDto(
            Long id,
            String content,
            Double score,
            String memberName
    ){
    }

    public record PostReviewDTO(
            Long id,
            Long storeId,
            BigDecimal score,
            String content,
            String memberName,
            LocalDateTime createdAt
    ) {}
}
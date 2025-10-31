package com.example.umc9th.domain.review.dto.res;

public class ReviewResponse {

    public record searchReviewDto(
            Long id,
            String content,
            Double score,
            String memberName
    ){
    }
}

package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.review.dto.res.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResponse.searchReviewDto toReviewDto(Review review) {
        return new ReviewResponse.searchReviewDto(
                review.getId(),
                review.getContent(),
                review.getScore().doubleValue(),
                review.getMember().getName()
        );
    }

    public static List<ReviewResponse.searchReviewDto> toReviewDto(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toReviewDto)
                .collect(Collectors.toList());
    }
}

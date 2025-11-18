package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static ReviewResDTO.searchReviewDto toReviewDto(Review review) {
        return new ReviewResDTO.searchReviewDto(
                review.getId(),
                review.getContent(),
                review.getScore().doubleValue(),
                review.getMember().getName()
        );
    }

    public static List<ReviewResDTO.searchReviewDto> toReviewDto(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toReviewDto)
                .collect(Collectors.toList());
    }

    public static Review toPostReview(ReviewReqDTO.PostReviewDTO dto, Member member, Store store) {
        return Review.builder()
                .content(dto.content())
                .score(dto.score())
                .member(member)
                .store(store)
                .build();
    }

    public static ReviewResDTO.PostReviewDTO toPostReviewDTO(Review review) {
        return new ReviewResDTO.PostReviewDTO(
                review.getId(),
                review.getStore().getId(),
                review.getScore(),
                review.getContent(),
                review.getMember().getName(),
                review.getCreatedAt()
        );
    }
}

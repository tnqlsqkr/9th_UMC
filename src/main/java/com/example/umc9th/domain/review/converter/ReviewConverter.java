package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;

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

    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResDTO.ReviewPreViewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDTO.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore().floatValue())
                .body(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }
}

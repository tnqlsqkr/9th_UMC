package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.res.ReviewResponse;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/search")
    public ApiResponse<List<ReviewResponse.searchReviewDto>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<Review> reviews = reviewQueryService.searchReview(query, type);

        List<ReviewResponse.searchReviewDto> result = ReviewConverter.toReviewDto(reviews);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK_200, result);
    }

    @GetMapping("/{memberId}/search")
    public ApiResponse<List<ReviewResponse.searchReviewDto>> searchMyReview(
            @RequestParam String query,
            @RequestParam String type,
            @PathVariable Long memberId
    ){
        List<Review> reviews = reviewQueryService.searchMyReview(memberId, query, type);

        List<ReviewResponse.searchReviewDto> result = ReviewConverter.toReviewDto(reviews);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK_200, result);
    }
}

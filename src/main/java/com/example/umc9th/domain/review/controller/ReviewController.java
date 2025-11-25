package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController implements ReviewControllerDocs{

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    @GetMapping("/search")
    public ApiResponse<List<ReviewResDTO.searchReviewDto>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ) {
        List<Review> reviews = reviewQueryService.searchReview(query, type);

        List<ReviewResDTO.searchReviewDto> result = ReviewConverter.toReviewDto(reviews);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK_200, result);
    }

    @GetMapping("/{memberId}/search")
    public ApiResponse<List<ReviewResDTO.searchReviewDto>> searchMyReview(
            @RequestParam String query,
            @RequestParam String type,
            @PathVariable Long memberId
    ){
        List<Review> reviews = reviewQueryService.searchMyReview(memberId, query, type);

        List<ReviewResDTO.searchReviewDto> result = ReviewConverter.toReviewDto(reviews);

        return ApiResponse.onSuccess(GeneralSuccessCode.OK_200, result);
    }

    @PostMapping("/store/{storeId}")
    public ApiResponse<ReviewResDTO.PostReviewDTO> postReview(
            @PathVariable Long storeId,
            @RequestBody ReviewReqDTO.PostReviewDTO dto
    ){
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED_201, reviewCommandService.postReview(storeId, dto));
    }

    @GetMapping("/member/{memberId}")
    @Override
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @PathVariable Long memberId,
            @RequestParam(defaultValue = "1") Integer page
    ) {
        return ApiResponse.onSuccess(ReviewSuccessCode.FOUND, reviewQueryService.findReview(memberId, page));
    }
}

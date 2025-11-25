package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;

import java.util.List;

public interface ReviewQueryService {
    List<Review> searchReview(String query, String type);
    List<Review> searchMyReview(Long memberId, String query, String type);

    ReviewResDTO.ReviewPreViewListDTO findReview(Long memberId, Integer page);
}

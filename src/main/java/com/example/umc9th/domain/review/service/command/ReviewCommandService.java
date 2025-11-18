package com.example.umc9th.domain.review.service.command;

import com.example.umc9th.domain.review.dto.req.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO.PostReviewDTO postReview(Long StoreId, ReviewReqDTO.PostReviewDTO DTO);
}

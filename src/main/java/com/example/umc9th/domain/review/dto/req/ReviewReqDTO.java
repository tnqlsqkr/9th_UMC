package com.example.umc9th.domain.review.dto.req;

import java.math.BigDecimal;

public class ReviewReqDTO {

    public record PostReviewDTO (
            Long memberId,
            BigDecimal score,
            String content
    ){}
}

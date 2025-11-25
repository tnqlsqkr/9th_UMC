package com.example.umc9th.domain.review.dto.res;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record ReviewPreViewDTO(
            String ownerNickname,
            Float score,
            String body,
            LocalDateTime createdAt
    ){}
}
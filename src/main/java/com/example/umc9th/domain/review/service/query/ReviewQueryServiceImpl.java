package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.exception.code.ReviewErrorCode;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public List<Review> searchReview(String query, String type) {

        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();

        switch (type) {
            case "location" -> builder.and(review.store.location.contains(query));
            case "score" -> builder.and(review.score.goe(new BigDecimal(query)));
            case "both" -> {
                String[] parts = query.split("&");
                if (parts.length != 2) {
                    throw new ReviewException(ReviewErrorCode.INVALID_QUERY_FORMAT);
                }
                builder.and(review.store.location.contains(parts[0]));
                builder.and(review.score.goe(new BigDecimal(parts[1])));
            }
            default -> throw new ReviewException(ReviewErrorCode.INVALID_SEARCH_TYPE);
        }

        List<Review> reviews = reviewRepository.searchReview(builder);

        if(reviews.isEmpty()){
            throw new ReviewException(ReviewErrorCode.NOT_FOUND_REVIEW);
        }

        return reviews;
    }

    @Override
    public List<Review> searchMyReview(Long memberId, String query, String type) {
        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(review.member.id.eq(memberId));

        switch (type) {
            case "store" -> builder.and(review.store.name.contains(query));

            case "score" -> {
                int star = Integer.parseInt(query);
                BigDecimal lower = new BigDecimal(star);
                BigDecimal upper = lower.add(BigDecimal.ONE);
                builder.and(review.score.goe(lower).and(review.score.lt(upper)));
            }

            case "both" -> {
                String[] parts = query.split(",");
                if (parts.length != 2) {
                    throw new ReviewException(ReviewErrorCode.INVALID_QUERY_FORMAT);
                }

                builder.and(review.store.name.contains(parts[0]));

                int star = Integer.parseInt(parts[1]);
                BigDecimal lower = new BigDecimal(star);
                BigDecimal upper = lower.add(BigDecimal.ONE);
                builder.and(review.score.goe(lower).and(review.score.lt(upper)));
            }

            default -> throw new ReviewException(ReviewErrorCode.INVALID_SEARCH_TYPE);
        }

        List<Review> reviews = reviewRepository.searchReview(builder);

        if(reviews.isEmpty()){
            throw new ReviewException(ReviewErrorCode.NOT_FOUND_REVIEW);
        }

        return reviews;
    }
}

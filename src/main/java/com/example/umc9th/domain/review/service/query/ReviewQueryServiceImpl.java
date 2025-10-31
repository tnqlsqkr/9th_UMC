package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
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

        if(type.equals("location")){
            builder.and(review.store.location.contains(query));
        }
        if(type.equals("score")){
            builder.and(review.score.goe(new BigDecimal(query)));
        }
        if(type.equals("both")) {
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            builder.and(review.store.location.contains(firstQuery));
            builder.and(review.score.goe(new BigDecimal(secondQuery)));
        }

        return reviewRepository.searchReview(builder);
    }

    @Override
    public List<Review> searchMyReview(Long memberId, String query, String type) {
        QReview review = QReview.review;

        BooleanBuilder builder = new BooleanBuilder();
        builder.and(review.member.id.eq(memberId));

        if(type.equals("store")){
            builder.and(review.store.name.contains(query));
        }
        if(type.equals("score")){
            int star = Integer.parseInt(query);
            BigDecimal lower = new BigDecimal(star);
            BigDecimal upper = lower.add(BigDecimal.ONE);

            builder.and(review.score.goe(lower)
                    .and(review.score.lt(upper)));
        }
        if(type.equals("both")) {
            String firstQuery = query.split(",")[0];
            String secondQuery = query.split(",")[1];

            builder.and(review.store.name.contains(firstQuery));

            int star = Integer.parseInt(secondQuery);
            BigDecimal lower = new BigDecimal(star);
            BigDecimal upper = lower.add(BigDecimal.ONE);

            builder.and(review.score.goe(lower)
                    .and(review.score.lt(upper)));
        }

        return reviewRepository.searchReview(builder);
    }
}

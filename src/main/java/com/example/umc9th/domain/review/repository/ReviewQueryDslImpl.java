package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final EntityManager em;

    @Override
    public List<Review> searchReview(Predicate predicate) {

        JPAQueryFactory qf = new JPAQueryFactory(em);

        QReview review = QReview.review;

        return qf
                .selectFrom(review)
                .leftJoin(review.member).fetchJoin()
                .leftJoin(review.store).fetchJoin()
                .where(predicate)
                .fetch();
    }
}

package com.example.umc9th.domain.review.service.query;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.ReviewException;
import com.example.umc9th.domain.review.exception.code.ReviewErrorCode;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.global.apiPayload.exception.page.PageErrorCode;
import com.example.umc9th.global.apiPayload.exception.page.PageException;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

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

    @Override
    public ReviewResDTO.ReviewPreViewListDTO findReview(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        if(page == null || page < 1){
            throw new PageException(PageErrorCode.PAGE_OUT_OF_RANGE);
        }

        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<Review> result = reviewRepository.findAllByMember(member, pageRequest);

        return ReviewConverter.toReviewPreviewListDTO(result);
    }
}

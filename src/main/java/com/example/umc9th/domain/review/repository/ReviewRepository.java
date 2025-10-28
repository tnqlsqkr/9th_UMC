package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByMemberIdOrderByCreatedAtDesc(Long memberId);

    List<Review> findAllByMemberIdOrderByCreatedAtDesc(Long memberId, Pageable pageable);
}

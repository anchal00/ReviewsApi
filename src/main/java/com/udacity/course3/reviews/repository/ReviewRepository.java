package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
}

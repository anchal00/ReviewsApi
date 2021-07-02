package com.udacity.course3.reviews.repository;

import java.util.List;

import com.udacity.course3.reviews.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByReviewId(Integer reviewId);

}

package com.udacity.course3.reviews.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "reviews")
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "review_title" )
    private String reviewTitle;
    
    @Column(name = "product_id")
    private Integer productId;

    @OneToMany
    @JoinColumn(name = "comment_id")
    @JsonIgnore
    private List<Comment> commentsForReview;

    public Review() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Review(Integer reviewId,List<Comment> commentsForReview, String reviewTitle) {
        this.reviewId = reviewId;
        this.commentsForReview = commentsForReview;
        this.reviewTitle = reviewTitle;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public List<Comment> getCommentsForReview() {
        return commentsForReview;
    }

    public void setCommentsForReview(List<Comment> commentsForReview) {
        this.commentsForReview = commentsForReview;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }
    
    
}

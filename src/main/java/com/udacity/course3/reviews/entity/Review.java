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

@Entity
@Table(name = "reviews")
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable =  false)
    private Product product;

    @OneToMany(mappedBy = "review")
    private List<Comment> commentsForReview;

    public Review() {
    }

    public Review(Integer reviewId, Product product, List<Comment> commentsForReview) {
        this.reviewId = reviewId;
        this.product = product;
        this.commentsForReview = commentsForReview;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Comment> getCommentsForReview() {
        return commentsForReview;
    }

    public void setCommentsForReview(List<Comment> commentsForReview) {
        this.commentsForReview = commentsForReview;
    }
    
    
}

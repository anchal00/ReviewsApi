package com.udacity.course3.reviews.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "review_id")
    @JsonIgnore
    private List<Review> reviewsOfProduct;

    public Product() {
    }

    public Product(Integer productId, String name, List<Review> reviewsOfProduct) {
        this.productId = productId;
        this.name = name;
        this.reviewsOfProduct = reviewsOfProduct;
    }

    public List<Review> getReviewsOfProduct() {
        return reviewsOfProduct;
    }

    public void setReviewsOfProduct(List<Review> reviewsOfProduct) {
        this.reviewsOfProduct = reviewsOfProduct;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}

package com.udacity.course3.reviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {
    
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void injectedComponentsAreNotNull() {

        assertNotNull(entityManager);
        assertNotNull(reviewRepository);
    }

    /**
     * Verifies that saving reviews in repo is done successfully and saved reviews
     * are assigned a unique ID as well.
     * 
     */

    @Test
    public void testReviewsAreSavedWithUniqueIds() {
        
        Product dummyProduct1 = new Product();
        dummyProduct1.setName("testProduct1");
        entityManager.persist(dummyProduct1);


        Review dummyReview1 = new Review();
        dummyReview1.setReviewTitle("dummy review 1");
        dummyReview1.setProductId(1);

        Review dummyReview2 = new Review();
        dummyReview2.setReviewTitle("dummy review 2");
        dummyReview2.setProductId(1);

        entityManager.persist(dummyReview1);
        entityManager.persist(dummyReview2);

        List<Review> savedReviews = reviewRepository.findByProductId(1);

        assertEquals(2, savedReviews.size());
        assertNotEquals(savedReviews.get(0).getReviewId(), savedReviews.get(1).getReviewId());


    }
}

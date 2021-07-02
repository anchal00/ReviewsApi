package com.udacity.course3.reviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void injectedComponentsAreNotNull() {

        assertNotNull(entityManager);
        assertNotNull(commentRepository);
    }

    @Test
    public void testCommentsForAReviewAreSavedWithUniqueIds() {
        Product dummyProduct1 = new Product();
        dummyProduct1.setName("testProduct1");
        entityManager.persist(dummyProduct1);

        Review dummyReview1 = new Review();
        dummyReview1.setReviewTitle("dummy review 1");
        dummyReview1.setProductId(1);
        entityManager.persist(dummyReview1);

        Comment dummyComment1 = new Comment();
        dummyComment1.setReviewId(1);
        dummyComment1.setContent("Test comment");

        Comment dummyComment2 = new Comment();
        dummyComment2.setReviewId(1);
        dummyComment2.setContent("Test comment");

        entityManager.persist(dummyComment1);
        entityManager.persist(dummyComment2);


        List<Comment> comments = commentRepository.findAll();

    
        assertEquals(2, comments.size());
        assertNotEquals(comments.get(0).getCommentId(), comments.get(1).getCommentId());
        assertTrue("Comments doesnt have same review Ids", comments.get(0).getReviewId() == comments.get(1).getReviewId() );

    }
}

package com.udacity.course3.reviews;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.repository.ProductRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {


    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void injectedComponentsAreNotNull() {

        assertNotNull(entityManager);
        assertNotNull(productRepository);
    }

    /**
     * Verifies that saving a product in repo is done successfully and saved product
     * is assigned a unique ID as well
     */

    @Test
    public void testProductsAreSavedWithUniqueIds() {

        Product dummyProduct1 = new Product();
        dummyProduct1.setName("testProduct1");

        Product dummyProduct2 = new Product();
        dummyProduct2.setName("testProduct2");

        entityManager.persist(dummyProduct1);
        entityManager.persist(dummyProduct2);

        List<Product> savedProduct = productRepository.findAll();

        assertEquals(2, savedProduct.size());
        assertNotEquals(savedProduct.get(0).getProductId(), savedProduct.get(1).getProductId());

    }
}

package com.udacity.course3.reviews;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

@SpringBootApplication
public class ReviewsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ReviewsApplication.class, args);
	}

}
CREATE TABLE products (
    product_id INTEGER PRIMARY KEY ,
    name VARCHAR(50) NOT NULL
);
ALTER TABLE products MODIFY COLUMN product_id INTEGER AUTO_INCREMENT;

CREATE TABLE reviews (
    review_id INTEGER PRIMARY KEY,
    review_title varchar(50) DEFAULT NULL,
    product_id INTEGER NOT NULL,
    
    CONSTRAINT fk_reviews FOREIGN KEY (product_id)  
    REFERENCES products(product_id)  
    ON DELETE CASCADE  
    ON UPDATE CASCADE 
);
ALTER TABLE reviews MODIFY COLUMN review_id INTEGER AUTO_INCREMENT;

CREATE TABLE comments (
    comment_id INTEGER PRIMARY KEY,
    review_id INTEGER NOT NULL ,
    content varchar(50) NOT NULL , 
    
    CONSTRAINT fk_comments FOREIGN KEY (review_id)  
    REFERENCES reviews(review_id)  
    ON DELETE CASCADE  
    ON UPDATE CASCADE 
);
ALTER TABLE comments MODIFY COLUMN comment_id INTEGER AUTO_INCREMENT;

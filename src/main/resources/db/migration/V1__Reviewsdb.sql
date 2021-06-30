CREATE TABLE products (
    product_id INTEGER PRIMARY KEY ,
    name VARCHAR(50) NOT NULL
);
ALTER TABLE products MODIFY COLUMN product_id INTEGER AUTO_INCREMENT;

CREATE TABLE reviews (
    review_id INTEGER PRIMARY KEY,
    product_id INTEGER NOT NULL,
    
    CONSTRAINT fk_reviews FOREIGN KEY (product_id)  
    REFERENCES products(product_id)  
    ON DELETE CASCADE  
    ON UPDATE CASCADE 
);

CREATE TABLE comments (
    comment_id INTEGER PRIMARY KEY,
    review_id INTEGER NOT NULL ,
    content varchar(50) NOT NULL , 
    
    CONSTRAINT fk_comments FOREIGN KEY (review_id)  
    REFERENCES reviews(review_id)  
    ON DELETE CASCADE  
    ON UPDATE CASCADE 
);

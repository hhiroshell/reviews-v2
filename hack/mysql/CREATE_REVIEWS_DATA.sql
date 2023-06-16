CREATE DATABASE reviews;

CREATE TABLE reviews.texts (
    id INT AUTO_INCREMENT,
    product_id INT,
    reviewer TEXT,
    text TEXT,
    PRIMARY KEY (id)
);

INSERT INTO reviews.texts (
    product_id,
    reviewer,
    text
) values (
    0,
    'Alice',
    'An extremely entertaining play by Shakespeare. The slapstick humour is refreshing!'
);

INSERT INTO reviews.texts (
    product_id,
    reviewer,
    text
) values (
    0,
    'Bob',
    'Absolutely fun and entertaining. The play lacks thematic depth when compared to other plays by Shakespeare.'
);

DROP TABLE author;
CREATE TABLE `author` (
  `author_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `birth_date` date DEFAULT NULL,
  `nationality` varchar(50) DEFAULT NULL,
  `other_author_details` text,
  PRIMARY KEY (`author_id`)
);


DROP TABLE book;
CREATE TABLE `book` (
  `book_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `publication_date` date DEFAULT NULL,
  `isbn` varchar(20) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `other_book_details` text,
  PRIMARY KEY (`book_id`)
);


DROP TABLE review;
CREATE TABLE `review` (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(100) NOT NULL,
  `rating` int DEFAULT NULL,
  `comments` text,
  `review_date` date DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  CONSTRAINT `review_chk_1` CHECK ((`rating` between 1 and 5))
);
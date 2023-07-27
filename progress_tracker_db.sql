drop database if exists book_database;
create database book_database;
use book_database;

CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    pass VARCHAR(255) NOT NULL,
    is_admin BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE book (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL
);

CREATE TABLE user_book (
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    rating TINYINT CHECK (rating BETWEEN 1 AND 5),
    status ENUM('incomplete', 'in-progress', 'complete'),
    
    PRIMARY KEY (user_id, book_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (book_id) REFERENCES book(book_id)
);

INSERT INTO user (username, pass, is_admin)
VALUES ('admin', '123456', 1);

-- Retrieve the generated user_id for the admin user
SET @admin_user_id := LAST_INSERT_ID();

-- Insert the book
INSERT INTO book (author, title)
VALUES ('The Wild Things', 'Some Guy');

-- Retrieve the generated book_id for the book
SET @book_id := LAST_INSERT_ID();

-- Insert the book record for the admin user in user_book table
INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@admin_user_id, @book_id, 5, 'complete');

INSERT INTO user (username, pass, is_admin)
VALUES ('alice', 'password123', 0);

SET @alice_user_id := LAST_INSERT_ID();

INSERT INTO user (username, pass, is_admin)
VALUES ('bob', 'secret123', 0);

SET @bob_user_id := LAST_INSERT_ID();

INSERT INTO user (username, pass, is_admin)
VALUES ('emma', '12345', 0);

SET @emma_user_id := LAST_INSERT_ID();

INSERT INTO user (username, pass, is_admin)
VALUES ('alex', 'abc123', 0);

SET @alex_user_id := LAST_INSERT_ID();

INSERT INTO user (username, pass, is_admin)
VALUES ('sophia', 'pass123', 0);

SET @sophia_user_id := LAST_INSERT_ID();

-- Insert books
INSERT INTO book (author, title)
VALUES ('George Orwell', '1984');

SET @book4_id := LAST_INSERT_ID();

INSERT INTO book (author, title)
VALUES ('Leo Tolstoy', 'War and Peace');

SET @book5_id := LAST_INSERT_ID();

INSERT INTO book (author, title)
VALUES ('Harper Lee', 'To Kill a Mockingbird');

SET @book6_id := LAST_INSERT_ID();

INSERT INTO book (author, title)
VALUES ('Charles Dickens', 'Great Expectations');

SET @book7_id := LAST_INSERT_ID();

INSERT INTO book (author, title)
VALUES ('Jane Austen', 'Pride and Prejudice');

SET @book8_id := LAST_INSERT_ID();

INSERT INTO book (author, title)
VALUES ('F. Scott Fitzgerald', 'The Great Gatsby');

SET @book9_id := LAST_INSERT_ID();

INSERT INTO book (author, title)
VALUES ('Mark Twain', 'Adventures of Huckleberry Finn');

SET @book10_id := LAST_INSERT_ID();

INSERT INTO book (author, title)
VALUES ('Victor Hugo', 'Les Misérables');

SET @book11_id := LAST_INSERT_ID();

INSERT INTO book (author, title)
VALUES ('Emily Bronte', 'Wuthering Heights');

SET @book12_id := LAST_INSERT_ID();

-- Insert user-book associations
INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@alice_user_id, @book4_id, 4, 'complete');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@alice_user_id, @book5_id, 5, 'in-progress');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@alice_user_id, @book6_id, 3, 'incomplete');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@bob_user_id, @book4_id, 5, 'complete');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@bob_user_id, @book7_id, 4, 'in-progress');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@bob_user_id, @book8_id, 5, 'complete');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@emma_user_id, @book9_id, 3, 'in-progress');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@emma_user_id, @book10_id, 4, 'incomplete');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@alex_user_id, @book7_id, 5, 'complete');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@alex_user_id, @book9_id, 4, 'in-progress');

INSERT INTO user_book (user_id, book_id, rating, status)
VALUES (@sophia_user_id, @book8_id, 3, 'incomplete');

-- Add more users and books, and their associations here if needed





drop database if exists book_database;
create database book_database;
use book_database;

CREATE TABLE user (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
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

INSERT INTO user (first_name, last_name, username, pass, is_admin)
VALUES ('Jordan', 'Taylor', 'admin', '123456', 1);

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




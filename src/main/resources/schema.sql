
USE `group_5_client_project`;
drop table if exists responses;
drop table if exists adminUsers;
drop table if exists questions;
drop table if exists responses;
drop table if exists submissions;
drop table if exists Reviews;
drop table if exists requests;
drop table if exists users;

-- -----------------------------------------------------

-- Create schema group_5_client_project

-- -----------------------------------------------------

 CREATE SCHEMA IF NOT EXISTS `group_5_client_project` DEFAULT CHARACTER SET utf8 ;

 USE `group_5_client_project`;



CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL,
    enabled boolean default true,
    role VARCHAR(50),
    PRIMARY KEY (id)
);


CREATE TABLE requests(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    approved VARCHAR(20) default 'pending',
    name VARCHAR(50) NOT NULL,
    requested Date default current_date,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users(id)
);

CREATE TABLE questions(
    id INT NOT NULL AUTO_INCREMENT,
    question_text VARCHAR(255) NOT NULL,
    date_added DATE NOT NULL,
    category VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE responses(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    answer1 INT NOT NULL,
    answer2 INT NOT NULL,
    answer3 INT NOT NULL,
    answer4 INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users(id)
);

CREATE TABLE Reviews(
    id INT NOT NULL AUTO_INCREMENT,
    userId INT NOT NULL ,
    requestID INT NOT NULL,
    status BOOLEAN DEFAULT FALSE,
    date_started DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (requestID) REFERENCES requests(id),
    FOREIGN KEY (userId) REFERENCES users(id)
);
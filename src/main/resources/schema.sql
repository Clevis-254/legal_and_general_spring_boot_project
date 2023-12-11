
drop table if exists answers;
drop table if exists submissions;
drop table if exists questions;
drop table if exists responses;
drop table if exists submissions;
drop table if exists Reviews;
drop table if exists contact_questions;
drop table if exists requests;
drop table if exists users;

-- -----------------------------------------------------

-- Create schema group_5_client_project

-- -----------------------------------------------------

 CREATE SCHEMA IF NOT EXISTS `group_5_client_project` DEFAULT CHARACTER SET utf8 ;

 USE `group_5_client_project`;

-- changed the database schema so that the admin is able to view the user first and second names when seeing
-- a request made
-- also the first and second names are used to add the users item into the user's table

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(255) NOT NULL,
    secondname VARCHAR(255) NOT NULL ,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL,
    enabled boolean default true,
    role VARCHAR(50) NOT NULL default'ROLE_USER',
    PRIMARY KEY (id)
);


-- changed the database schema so that the admin is able to view the user first and second names when seeing
-- a request made
-- also the first and second names are used to add the users item into the user's table
CREATE TABLE requests(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    approved VARCHAR(20) default 'pending',
    firstname VARCHAR(50) NOT NULL,
    secondname varchar(50) not null ,
    requested Date default current_date,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users(id)
);
CREATE TABLE Reviews(
    id INT NOT NULL AUTO_INCREMENT,
    userId INT NOT NULL ,
    requestID INT NOT NULL,
    status varchar(50) not null default 'in_progress',
    date_started Date default current_date,
    PRIMARY KEY (id),
    FOREIGN KEY (requestID) REFERENCES requests(id),
    FOREIGN KEY (userId) REFERENCES users(id)
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


CREATE TABLE contact_questions(
    id INT not null  auto_increment,
    question VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL ,
    date_added  Date default current_date,
    primary key (id)
);
CREATE TABLE submissions(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    reviewID INT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users(id),
    FOREIGN KEY (reviewID) REFERENCES Reviews(id)
);

CREATE TABLE answers
(
    id          INT          NOT NULL AUTO_INCREMENT,
    question_id INT          NOT NULL,
    sub_id      INT          NOT NULL,
    answer      VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES questions (id),
    FOREIGN KEY (sub_id) REFERENCES submissions (id)
);

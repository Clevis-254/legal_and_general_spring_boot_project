drop table if exists answers;
drop table if exists submissions;
drop table if exists questions;
drop table if exists responses;
drop table if exists submissions;
drop table if exists contacts;
drop table if exists results;
drop table if exists reviews;
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
CREATE TABLE reviews(
    id INT NOT NULL AUTO_INCREMENT,
    userId INT NOT NULL ,
    requestID INT NOT NULL,
    status varchar(50) not null default 'in_progress',
    date_started Date default current_date,
    PRIMARY KEY (id),
    FOREIGN KEY (requestID) REFERENCES requests(id),
    FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE if not exists results(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    date_added DATE NOT NULL,
    current_status VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users(id)
);

CREATE TABLE questions(
    id INT NOT NULL AUTO_INCREMENT,
    question_num INT NOT NULL,
    question_user_text VARCHAR(255) NOT NULL,
    question_contact_text VARCHAR(255) NOT NULL,
    date_added DATETIME NOT NULL,
    category VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE contacts(
    id INT NOT NULL AUTO_INCREMENT,
    fname VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    category VARCHAR(50),
    reviewsId INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (reviewsId) REFERENCES reviews(id));

CREATE TABLE submissions(
id INT NOT NULL AUTO_INCREMENT,
contactID INT NOT NULL,
reviewID INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (contactID) REFERENCES contacts(id),
FOREIGN KEY (reviewID) REFERENCES reviews(id)
);
CREATE TABLE contact_questions(
id INT not null  auto_increment,
questionNumb INT NOT NULL ,
question VARCHAR(255) NOT NULL,
category VARCHAR(50) NOT NULL ,
date_added  Date default current_date,
primary key (id)
);

CREATE TABLE answers
    (
        id INT NOT NULL AUTO_INCREMENT,
        questionID INT NOT NULL,
        answer VARCHAR(255) NOT NULL,
        subID INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (questionID) REFERENCES contact_questions(id),
        FOREIGN KEY (subID) REFERENCES submissions(id)
    );



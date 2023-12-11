use group_5_client_project;
DROP TABLE IF EXISTS submissions;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS results;
DROP TABLE IF EXISTS users;

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

CREATE TABLE results(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    date_added DATE NOT NULL,
    current_status VARCHAR(30) NOT NULL,
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

CREATE TABLE contacts(
    id INT NOT NULL AUTO_INCREMENT,
    fname VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    category VARCHAR(50),
    result_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (result_id) REFERENCES results(id));

CREATE TABLE answers
    (
        id INT NOT NULL AUTO_INCREMENT,
        questionID INT NOT NULL,
        answer VARCHAR(255) NOT NULL,
        subID INT NOT NULL,
        PRIMARY KEY (id),
        FOREIGN KEY (questionID) REFERENCES questions(id),
        FOREIGN KEY (subID) REFERENCES submissions(id)
    );

CREATE TABLE submissions(
                            id INT NOT NULL AUTO_INCREMENT,
                            userID INT,
                            contactID INT,
                            resultsID INT NOT NULL,
                            PRIMARY KEY (id),
                            FOREIGN KEY (userID) REFERENCES users(id),
                            FOREIGN KEY (contactID) REFERENCES contacts(id),
                            FOREIGN KEY (resultsID) REFERENCES results(id)
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

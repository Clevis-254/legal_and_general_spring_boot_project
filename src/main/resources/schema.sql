drop table if exists adminUsers;
drop table if exists requests;
drop table if exists questions;
drop table if exists users;

-- -----------------------------------------------------

-- Create schema group_5_client_project

-- -----------------------------------------------------

-- CREATE SCHEMA IF NOT EXISTS `group_5_client_project` DEFAULT CHARACTER SET utf8 ;

-- USE `group_5_client_project`;



CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL,
    enabled boolean default true,
    role VARCHAR(50) default 'ROLE_USER',
    PRIMARY KEY (id)
);

CREATE TABLE adminUsers(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users(id)
);

CREATE TABLE requests(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    approval BOOLEAN default false,
    username VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users(id)
);

CREATE TABLE questions(
    id INT NOT NULL AUTO_INCREMENT,
    employeeText VARCHAR(255) NOT NULL,
    externalText VARCHAR(255) NOT NULL,
    date_added DATE NOT NULL,
    category VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
)
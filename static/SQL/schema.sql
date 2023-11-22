DROP SCHEMA IF EXISTS `group_5_client_project` ;

-- -----------------------------------------------------

-- Create schema group_5_client_project

-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `group_5_client_project` DEFAULT CHARACTER SET utf8 ;

USE `group_5_client_project` ;

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
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
    approved BOOLEAN NOT NULL,
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
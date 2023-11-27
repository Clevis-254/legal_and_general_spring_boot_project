DROP SCHEMA IF EXISTS `group_5_client_project` ;

-- -----------------------------------------------------

-- Create schema group_5_client_project

-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `group_5_client_project` DEFAULT CHARACTER SET utf8 ;

USE `group_5_client_project` ;

CREATE TABLE if not exists users(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    isadmin BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);



CREATE TABLE if not exists requests(
    id INT NOT NULL AUTO_INCREMENT,
    userID INT NOT NULL,
    approved BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userID) REFERENCES users(id)
);
DROP DATABASE IF EXISTS proj1;
CREATE DATABASE proj1;

USE proj1;

CREATE TABLE article (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	subject char(100) NOT NULL UNIQUE,
	content text,
	memberId int UNSIGNED NOT NULL,
	regDate DATETIME NOT NULL
);

INSERT INTO article
    SET id = 3,
    subject = 'test3',
    content = 'test3',
    memberId = 3,
    regDate = now();

SELECT * FROM article;

CREATE TABLE `member` (
    id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userId char(100) NOT NULL UNIQUE,
    `password` char(100) NOT NULL,
    regDate DATETIME NOT NULL
);

INSERT INTO `member`
    SET id = 3,
    userId = 3,
    `password` = 'asd',
    regDate = now();

SELECT * FROM `member`;
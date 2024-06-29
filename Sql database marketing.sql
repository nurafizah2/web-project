USE User;

CREATE TABLE Admin(
id INT NOT NULL AUTO_INCREMENT,
username varchar(255),
password varchar(255),
role varchar(255),
PRIMARY KEY(id));

CREATE TABLE Client(
id INT NOT NULL AUTO_INCREMENT,
username varchar(255),
password varchar(255),
role varchar(255),
PRIMARY KEY(id));

CREATE TABLE marketing (
    id INT AUTO_INCREMENT PRIMARY KEY,
    log_date DATE NOT NULL,
    description TEXT
);

CREATE TABLE socmed (
    id INT AUTO_INCREMENT PRIMARY KEY,
    log_date DATE NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE casestudy (
    id INT AUTO_INCREMENT PRIMARY KEY,
    log_date DATE NOT NULL,
    description TEXT
);
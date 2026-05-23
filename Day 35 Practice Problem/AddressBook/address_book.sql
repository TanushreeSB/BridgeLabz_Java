-- =========================================================
-- ADDRESS BOOK DATABASE - COMPLETE SQL FILE
-- =========================================================

-- =========================================================
-- UC 1 : CREATE DATABASE
-- =========================================================

CREATE DATABASE address_book_service;

SHOW DATABASES;

USE address_book_service;

-- =========================================================
-- UC 2 : CREATE ADDRESS_BOOK TABLE
-- =========================================================

CREATE TABLE address_book (
    address_book_id INT PRIMARY KEY AUTO_INCREMENT,
    address_book_name VARCHAR(100) NOT NULL UNIQUE
);

-- =========================================================
-- UC 3 : CREATE CONTACT TABLE
-- =========================================================

CREATE TABLE contact (
    contact_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    zip VARCHAR(20),
    phone_number VARCHAR(15),
    email VARCHAR(150),
    date_added DATE DEFAULT (CURRENT_DATE),
    is_active BOOLEAN DEFAULT TRUE
);

-- =========================================================
-- UC 4 : CREATE ADDRESS_BOOK_CONTACT TABLE
-- MANY TO MANY RELATIONSHIP
-- =========================================================

CREATE TABLE address_book_contact (
    address_book_id INT,
    contact_id INT,

    PRIMARY KEY(address_book_id, contact_id),

    FOREIGN KEY(address_book_id)
    REFERENCES address_book(address_book_id)
    ON DELETE CASCADE,

    FOREIGN KEY(contact_id)
    REFERENCES contact(contact_id)
    ON DELETE CASCADE
);

-- =========================================================
-- UC 5 : INSERT ADDRESS BOOKS
-- =========================================================

INSERT INTO address_book(address_book_name)
VALUES
('Family'),
('Friends'),
('Office');

-- =========================================================
-- UC 6 : INSERT CONTACTS
-- =========================================================

INSERT INTO contact
(first_name, last_name, address,
city, state, zip,
phone_number, email)
VALUES

('John', 'Doe', 'Anna Nagar',
'Chennai', 'Tamil Nadu', '600001',
'9876543210', 'john@gmail.com'),

('Priya', 'Sharma', 'MG Road',
'Bangalore', 'Karnataka', '560001',
'9999999999', 'priya@gmail.com'),

('Rahul', 'Kumar', 'Andheri',
'Mumbai', 'Maharashtra', '400001',
'8888888888', 'rahul@gmail.com'),

('Sneha', 'Patel', 'Satellite',
'Ahmedabad', 'Gujarat', '380001',
'7777777777', 'sneha@gmail.com');

-- =========================================================
-- UC 7 : MAP CONTACTS TO ADDRESS BOOKS
-- =========================================================

INSERT INTO address_book_contact
(address_book_id, contact_id)
VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 3),
(1, 4);

-- =========================================================
-- UC 8 : RETRIEVE ALL CONTACTS
-- =========================================================

SELECT *
FROM contact;

-- =========================================================
-- UC 9 : RETRIEVE CONTACTS WITH ADDRESS BOOK
-- =========================================================

SELECT
ab.address_book_name,
c.first_name,
c.last_name,
c.city,
c.state,
c.phone_number,
c.email
FROM address_book ab
INNER JOIN address_book_contact abc
ON ab.address_book_id = abc.address_book_id
INNER JOIN contact c
ON abc.contact_id = c.contact_id;

-- =========================================================
-- UC 10 : EDIT CONTACT
-- =========================================================

UPDATE contact
SET city = 'Coimbatore',
    state = 'Tamil Nadu'
WHERE first_name = 'John'
AND last_name = 'Doe';

-- =========================================================
-- UC 11 : DELETE CONTACT (SOFT DELETE)
-- =========================================================

UPDATE contact
SET is_active = FALSE
WHERE first_name = 'Rahul'
AND last_name = 'Kumar';

-- =========================================================
-- UC 12 : RETRIEVE ONLY ACTIVE CONTACTS
-- =========================================================

SELECT *
FROM contact
WHERE is_active = TRUE;

-- =========================================================
-- UC 13 : SEARCH PERSON BY CITY
-- =========================================================

SELECT *
FROM contact
WHERE city = 'Chennai';

-- =========================================================
-- UC 14 : SEARCH PERSON BY STATE
-- =========================================================

SELECT *
FROM contact
WHERE state = 'Tamil Nadu';

-- =========================================================
-- UC 15 : VIEW PERSONS BY CITY
-- =========================================================

SELECT city,
GROUP_CONCAT(first_name, ' ', last_name)
AS persons
FROM contact
GROUP BY city;

-- =========================================================
-- UC 16 : VIEW PERSONS BY STATE
-- =========================================================

SELECT state,
GROUP_CONCAT(first_name, ' ', last_name)
AS persons
FROM contact
GROUP BY state;

-- =========================================================
-- UC 17 : COUNT BY CITY
-- =========================================================

SELECT city,
COUNT(*) AS total_contacts
FROM contact
GROUP BY city;

-- =========================================================
-- UC 18 : COUNT BY STATE
-- =========================================================

SELECT state,
COUNT(*) AS total_contacts
FROM contact
GROUP BY state;

-- =========================================================
-- UC 19 : SORT BY PERSON NAME
-- =========================================================

SELECT *
FROM contact
ORDER BY first_name, last_name;

-- =========================================================
-- UC 20 : SORT BY CITY
-- =========================================================

SELECT *
FROM contact
ORDER BY city;

-- =========================================================
-- UC 21 : SORT BY STATE
-- =========================================================

SELECT *
FROM contact
ORDER BY state;

-- =========================================================
-- UC 22 : SORT BY ZIP
-- =========================================================

SELECT *
FROM contact
ORDER BY zip;

-- =========================================================
-- UC 23 : RETRIEVE CONTACTS ADDED BETWEEN DATES
-- =========================================================

SELECT *
FROM contact
WHERE date_added BETWEEN
CAST('2024-01-01' AS DATE)
AND DATE(NOW());

-- =========================================================
-- UC 24 : COUNT CONTACTS BY CITY USING DB FUNCTION
-- =========================================================

SELECT city,
COUNT(contact_id) AS total_contacts
FROM contact
GROUP BY city;

-- =========================================================
-- UC 25 : COUNT CONTACTS BY STATE USING DB FUNCTION
-- =========================================================

SELECT state,
COUNT(contact_id) AS total_contacts
FROM contact
GROUP BY state;

-- =========================================================
-- UC 26 : CHECK DUPLICATE CONTACT
-- =========================================================

SELECT *
FROM contact
WHERE first_name = 'John'
AND last_name = 'Doe';

-- =========================================================
-- UC 27 : COMPLETE JOIN QUERY
-- =========================================================

SELECT
c.contact_id,
c.first_name,
c.last_name,
c.address,
c.city,
c.state,
c.zip,
c.phone_number,
c.email,
c.date_added,
ab.address_book_name
FROM contact c
LEFT JOIN address_book_contact abc
ON c.contact_id = abc.contact_id
LEFT JOIN address_book ab
ON abc.address_book_id = ab.address_book_id
WHERE c.is_active = TRUE;

-- =========================================================
-- UC 28 : DELETE TABLES
-- =========================================================

-- DROP TABLE address_book_contact;
-- DROP TABLE contact;
-- DROP TABLE address_book;

-- =========================================================
-- END OF SQL FILE
-- =========================================================
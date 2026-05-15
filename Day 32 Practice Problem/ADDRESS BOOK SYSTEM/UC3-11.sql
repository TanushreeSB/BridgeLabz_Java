
-- UC3: Insert Contacts
-- =========================
INSERT INTO address_book
(first_name, last_name, address, city, state, zip, phone, email)
VALUES
('John', 'Doe', 'Street 1', 'Chennai', 'TN', '600001', '9876543210', 'john@gmail.com'),
('Alice', 'Smith', 'Street 2', 'Mumbai', 'MH', '400001', '9876543211', 'alice@gmail.com');

-- =========================
-- UC4: Edit Contact
-- =========================
UPDATE address_book
SET city = 'Bangalore'
WHERE first_name = 'John';

-- =========================
-- UC5: Delete Contact
-- =========================
DELETE FROM address_book
WHERE first_name = 'Alice';

-- =========================
-- UC6: Retrieve by City/State
-- =========================
SELECT * FROM address_book WHERE city = 'Chennai';
SELECT * FROM address_book WHERE state = 'TN';

-- =========================
-- UC7: Count by City/State
-- =========================
SELECT city, COUNT(*) AS count
FROM address_book
GROUP BY city;

SELECT state, COUNT(*) AS count
FROM address_book
GROUP BY state;

-- =========================
-- UC8: Sort by Person Name in City
-- =========================
SELECT * FROM address_book
WHERE city = 'Chennai'
ORDER BY first_name;

-- =========================
-- UC9: Add Address Book Type
-- =========================
ALTER TABLE address_book
ADD book_name VARCHAR(50),
    book_type VARCHAR(50);

-- =========================
-- UC10: Count by Type
-- =========================
SELECT book_type, COUNT(*) AS total_contacts
FROM address_book
GROUP BY book_type;

-- =========================
-- UC11: Person in Multiple Groups
-- =========================
INSERT INTO address_book
(first_name, last_name, address, city, state, zip, phone, email, book_name, book_type)
VALUES
('David', 'Roy', 'Street 3', 'Chennai', 'TN', '600002', '9999999999', 'david@gmail.com', 'FriendsBook', 'Friends'),
('David', 'Roy', 'Street 3', 'Chennai', 'TN', '600002', '9999999999', 'david@gmail.com', 'FamilyBook', 'Family');

-- =========================
-- UC13: Final Check Queries
-- =========================
SELECT * FROM address_book;

SELECT book_type, COUNT(*) FROM address_book GROUP BY book_type;

SELECT city, COUNT(*) FROM address_book GROUP BY city;

SELECT * FROM address_book ORDER BY first_name;
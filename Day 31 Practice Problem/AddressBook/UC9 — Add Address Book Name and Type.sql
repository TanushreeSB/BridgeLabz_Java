ALTER TABLE address_book
ADD address_book_name VARCHAR(100),
ADD address_book_type VARCHAR(100);

UPDATE address_book
SET address_book_name = 'FriendsBook',
address_book_type = 'Friends'
WHERE first_name = 'John';
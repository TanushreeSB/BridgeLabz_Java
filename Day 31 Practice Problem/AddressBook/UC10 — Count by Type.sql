SELECT address_book_type,
COUNT(*) AS total_contacts
FROM address_book
GROUP BY address_book_type;
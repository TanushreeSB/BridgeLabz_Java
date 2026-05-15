SELECT city,
COUNT(*) AS total_persons
FROM address_book
GROUP BY city;

SELECT state,
COUNT(*) AS total_persons
FROM address_book
GROUP BY state;

-- countBooksByOrderStatus
SELECT SUM(books_count) amount
FROM (
	SELECT order_id, SUM(total_books) books_count
	FROM (
		SELECT oib.order_item_id, COUNT(*) AS total_books
		FROM (
			SELECT books.id book_id
            FROM (
				SELECT b.id, b.book_metadata_id
				FROM (
					SELECT abt.book_template_id
					FROM author_book_template abt
					WHERE abt.author_id = 1
				) ab_template
				JOIN book b
				ON ab_template.book_template_id = b.book_template_id
			) books
			JOIN book_metadata bm
			ON books.book_metadata_id = bm.id
		) bm_books
		JOIN order_item_books oib
		ON bm_books.book_id = oib.book_id
		GROUP BY oib.order_item_id
	) order_tb
	JOIN order_item oi
	ON order_tb.order_item_id = oi.id
    GROUP BY oi.order_id) orders
JOIN `order` o
ON orders.order_id = o.id
WHERE o.status = 'COMPLETE_DELIVERY';

-- coountBooksInSubCategory
SELECT sc.name
FROM (
	SELECT b.sub_category_id, COUNT(DISTINCT ab_template.book_template_id) unique_book_template
	FROM (
		SELECT abt.book_template_id
		FROM author_book_template abt
		WHERE abt.author_id = 1
	) ab_template
	JOIN book b
	ON ab_template.book_template_id = b.book_template_id
	GROUP BY b.sub_category_id
	ORDER BY unique_book_template DESC) sc_book_template
JOIN sub_category sc
ON sc_book_template.sub_category_id = sc.id;

-- countOrdersInRange
SELECT COUNT(*) amount
FROM (
	SELECT order_id, total_books
	FROM (
		SELECT oib.order_item_id, COUNT(*) AS total_books
		FROM (
			SELECT b.id
			FROM (
				SELECT abt.book_template_id
				FROM author_book_template abt
				WHERE abt.author_id = 1
			) ab_template
			JOIN book b
			ON ab_template.book_template_id = b.book_template_id
		) books
		JOIN order_item_books oib
		ON books.id = oib.book_id
		GROUP BY oib.order_item_id
	) order_tb
	JOIN order_item oi
	ON order_tb.order_item_id = oi.id) orders
JOIN `order` o
ON orders.order_id = o.id
WHERE o.status = 'COMPLETE_DELIVERY' AND (o.order_date BETWEEN '2024-11-03' AND '2024-11-10');

-- countBooksInRange
SELECT SUM(books_count) amount
FROM (
	SELECT order_id, SUM(total_books) books_count
	FROM (    
		SELECT oib.order_item_id, COUNT(*) AS total_books
		FROM (
			SELECT books.id book_id
            FROM (
				SELECT b.id, b.book_metadata_id
				FROM (
					SELECT abt.book_template_id
					FROM author_book_template abt
					WHERE abt.author_id = 1
				) ab_template
				JOIN book b
				ON ab_template.book_template_id = b.book_template_id
			) books
			JOIN book_metadata bm
			ON books.book_metadata_id = bm.id
			WHERE bm.status = 'SOLD'
		) bm_books
		JOIN order_item_books oib
		ON bm_books.book_id = oib.book_id
		GROUP BY oib.order_item_id
	) order_tb
	JOIN order_item oi
	ON order_tb.order_item_id = oi.id
    GROUP BY oi.order_id) orders
JOIN `order` o
ON orders.order_id = o.id
WHERE o.status = 'COMPLETE_DELIVERY' AND (o.order_date BETWEEN '2024-11-03' AND '2024-11-10');

-- calculateValueOrdersSoldByStatus
SELECT SUM(sum_books) amount
FROM (
	SELECT order_id, SUM(sum_order_item) sum_books
	FROM (
		SELECT oib.order_item_id, SUM(books.selling_price) sum_order_item
		FROM (
			SELECT b.id, b.selling_price
			FROM (
				SELECT abt.book_template_id
				FROM author_book_template abt
				WHERE abt.author_id = 1
			) ab_template
			JOIN book b
			ON ab_template.book_template_id = b.book_template_id
		) books
		JOIN order_item_books oib
		ON books.id = oib.book_id
		GROUP BY oib.order_item_id
	) order_tb
	JOIN order_item oi
	ON order_tb.order_item_id = oi.id
    GROUP BY oi.order_id) orders
JOIN `order` o
ON orders.order_id = o.id
WHERE o.status = 'COMPLETE_DELIVERY';

-- countOrdersByStatus
SELECT COUNT(*) amount
FROM (
	SELECT order_id, total_books
	FROM (
		SELECT oib.order_item_id, COUNT(*) AS total_books
		FROM (
			SELECT b.id
			FROM (
				SELECT abt.book_template_id
				FROM author_book_template abt
				WHERE abt.author_id = 1
			) ab_template
			JOIN book b
			ON ab_template.book_template_id = b.book_template_id
		) books
		JOIN order_item_books oib
		ON books.id = oib.book_id
		GROUP BY oib.order_item_id
	) order_tb
	JOIN order_item oi
	ON order_tb.order_item_id = oi.id) orders
JOIN `order` o
ON orders.order_id = o.id
WHERE o.status = 'COMPLETE_DELIVERY';

-- calculateAverageRating
SELECT COALESCE(AVG(review.rate), 0) AS average_amount 
FROM (
	SELECT abt.book_template_id 
	FROM author_book_template abt 
	WHERE abt.author_id = 1
) ab_template
JOIN review
ON ab_template.book_template_id = review.book_template_id;


select p.product_id, p.product_name from product p
join (select product_id, max(sale_date) as sale_date from sales group by product_id having year(min(sale_date)) = 2019) j
on p.product_id = j.product_id where quarter(j.sale_date) = 1 and year(j.sale_date) = 2019;
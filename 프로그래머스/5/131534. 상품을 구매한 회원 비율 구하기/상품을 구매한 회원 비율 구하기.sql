SELECT
    YEAR(o.sales_date) AS YEAR
    ,MONTH(o.sales_date) AS MONTH
    ,COUNT(DISTINCT o.user_id) AS PURCHASED_USERS
    ,ROUND(
        (COUNT(DISTINCT o.user_id) / (
            SELECT 
            COUNT(*) 
            FROM user_info 
            WHERE YEAR(joined) = 2021)
        ), 1) AS PURCHASED_RATIO
FROM user_info u
JOIN online_sale o ON u.user_id = o.user_id
WHERE YEAR(u.joined) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR ASC, MONTH ASC
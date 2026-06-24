SELECT member_id, member_name, gender, date_of_birth
FROM member_profile
WHERE MONTH(date_of_birth) = 3 AND TLNO IS NOT NULL AND GENDER LIKE "W"
ORDER BY member_id asc;
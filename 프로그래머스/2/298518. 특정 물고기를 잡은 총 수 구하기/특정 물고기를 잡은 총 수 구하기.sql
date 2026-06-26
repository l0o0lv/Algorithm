SELECT COUNT(*) AS fish_count
FROM fish_info i
JOIN fish_name_info n ON i.FISH_TYPE = n.FISH_TYPE
WHERE fish_name LIKE 'BASS' OR fish_name LIKE 'SNAPPER'
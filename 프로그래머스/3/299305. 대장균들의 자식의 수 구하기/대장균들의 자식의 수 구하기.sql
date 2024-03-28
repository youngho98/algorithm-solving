SELECT ID, ifnull(t2.cnt, 0) AS CHILD_COUNT
FROM ecoli_data AS t1
LEFT JOIN (SELECT parent_id, count(*) AS cnt
            FROM ecoli_data
            GROUP BY parent_id) AS t2
ON t1.id = t2.parent_id;
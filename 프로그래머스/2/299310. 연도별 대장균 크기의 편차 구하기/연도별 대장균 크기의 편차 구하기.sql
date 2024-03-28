SELECT year(differentiation_date) AS YEAR, (t2.max_size - t1.size_of_colony) AS YEAR_DEV, ID
FROM ecoli_data AS t1
LEFT JOIN (SELECT max(size_of_colony) AS max_size, year(differentiation_date) AS year
            FROM ecoli_data
            GROUP BY year(differentiation_date)) AS t2
ON year(t1.differentiation_date) = t2.year
ORDER BY year, year_dev;
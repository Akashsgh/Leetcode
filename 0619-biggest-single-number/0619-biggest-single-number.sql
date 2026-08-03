# Write your MySQL query statement below
select max(num) as num
-- subquerry likhenge
from(
    select num
    from MyNumbers
    group by num
    having count(*)=1
) as n;



-- n count as temporary 
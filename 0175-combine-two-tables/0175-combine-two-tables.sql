# Write your MySQL query statement below
select Person.firstName,
Person.lastName,

Address.city,
Address.state
from Person
left join Address
on Person.personId=Address.personId;
-- SELECT Person.firstName,
-- Person.lastName,
-- Address.city, 
-- Address.state
-- FROM Person
-- LEFT JOIN Address
-- ON Person.personId=Address.personId;

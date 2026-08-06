# Write your MySQL query statement below
select 
u.unique_id,
e.name

From Employees e
left join EmployeeUNI u
on e.id=u.id;
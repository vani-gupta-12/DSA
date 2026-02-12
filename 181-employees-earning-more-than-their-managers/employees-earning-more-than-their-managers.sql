# Write your MySQL query statement below
select e.name as Employee
from Employee m join employee e 
on e.managerId = m.id 
where e.salary > m.salary;
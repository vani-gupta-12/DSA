# Write your MySQL query statement below
/*select e.name as Employee
from Employee m join employee e 
on e.managerId = m.id 
where e.salary > m.salary;*/
select name as Employee from Employee e where salary >= (select salary from  Employee m where e.managerId = m.id);
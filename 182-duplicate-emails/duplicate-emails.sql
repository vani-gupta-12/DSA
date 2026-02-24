# Write your MySQL query statement below
/*select email from person group by email having count(email) > 1;*/
select email as Email from  (select email from person group by email having count(email)>1) as duplicate;
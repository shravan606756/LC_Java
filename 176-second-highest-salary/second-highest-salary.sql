# Write your MySQL query statement below
select max(e2.salary) as SecondHighestSalary
from employee e1 inner join employee e2
where e1.salary>e2.salary
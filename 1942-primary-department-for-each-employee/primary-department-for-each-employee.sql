# Write your MySQL query statement below
#if 1 then primary, else if 'y' then primary

select employee_id, department_id
from employee
where employee_id in(
    select employee_id
    from employee
    group by employee_id
    having count(employee_id)=1
) or primary_flag='Y'
order by employee_id
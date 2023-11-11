# Write your MySQL query statement below


select d.name as 'Department', e.name as 'Employee', e.salary as 'Salary' from (
    select dInner.id, max(salary) as 'salary' from Department dInner
    inner join Employee eInner on eInner.departmentId = dInner.id
    group by dInner.id) as maxDep
    inner join Employee e on e.salary = maxDep.salary and e.departmentId = maxDep.id
    inner join Department d on d.id = maxDep.id


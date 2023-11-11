# Write your MySQL query statement below

select * from 
(select 
(case 
when s.id % 2 = 0 then s.id - 1
when s.id = (select max(id) from Seat) then s.id
else s.id + 1
end) as 'id',
student
from Seat s) as s order by id

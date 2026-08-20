# Write your MySQL query statement below
select round(count(distinct player_id) / (select count(distinct player_id) from Activity), 2) as fraction
from activity
where(player_id, date_sub(event_date, interval 1 day)) in (
    select player_id, min(event_date) as firstdate
    from Activity
    group by player_id
)
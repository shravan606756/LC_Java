# Write your MySQL query statement below
(
    select name as results
    from users join movierating using(user_id)
    group by name, user_id
    order by count(rating) desc, name asc
    limit 1
)

union all
(
    select title as results
    from movies join movierating using(movie_id)
    where month(created_at) = '02' and year(created_at) = '2020'
    group by title
    order by avg(rating) desc, title asc
    limit 1
)
with min_max_purchase as (
    select distinct b.*, sum(prod.price) as money
    from buyer b
             join purchase pur
                  on pur.id_buyer = b.id
             join products prod
                  on pur.id_product = prod.id
    where 1 = 1
    group by b.id, b.name, lastname)
select min_max_purchase.lastname, min_max_purchase.name
from min_max_purchase
where 1 =1
  and min_max_purchase.money > '100000'
  and min_max_purchase.money < '400000';
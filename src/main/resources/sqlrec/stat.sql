select b.id as identity, b.lastname as b_lastName, b.name as b_name, prod.name as prodname, sum(prod.price) as all_price
from products prod
         join purchase pur
              on prod.id = pur.id_product
         join buyer b
              on pur.id_buyer = b.id
where 1 = 1
  and pur.date_purchase > '=startTime='
  and pur.date_purchase < '=endTime='
group by identity, b_lastName, b_name, prodname
order by identity, all_price;
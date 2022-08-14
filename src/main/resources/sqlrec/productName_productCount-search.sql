select distinct b.*
from buyer b
         join purchase pur
              on pur.id_buyer = b.id
         join products prod
              on pur.id_product = prod.id
where 1 = 1
  and prod.name like '=productName='
group by b.id, b.name, b.lastname
having count(pur.id) >= '=countBuy=';
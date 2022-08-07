-- Создание m2m таблицы с покупками
create table purchase
(
    id            bigserial primary key,
    id_buyer      bigserial not null,
    id_product    bigserial not null,
    date_purchase date      not null,
    foreign key (id_buyer) references buyer (id),
    foreign key (id_product) references products (id)
);

-- Заполнение таблицы m2m

do
$do$
    declare
        i int;
    BEGIN
        for i in 1..500
            loop
                insert into purchase (id_buyer, id_product, date_purchase)
                values (floor(random() * 10 + 1), floor(random() * 9 + 1), now():: date - floor((random() * 100))::int);
            end loop;
    end;
$do$


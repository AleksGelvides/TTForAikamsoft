-- Создание таблицы с товарами
create table products
(
    id bigserial primary key,
    price numeric,
    name varchar
);

-- Наполнение таблицы с покупателями
insert into products (price, name)
values (10000.99, 'Стол');
insert into products (price, name)
values (39900.00, 'Компьютер');
insert into products (price, name)
values (700.65, 'Раковина');
insert into products (price, name)
values (12500.55, 'Кровать');
insert into products (price, name)
values (12000.99, 'Кофеварка');
insert into products (price, name)
values (7.50, 'Мотыга');
insert into products (price, name)
values (430.22, 'Пачка карандашей');
insert into products (price, name)
values (990.99, 'Светильник');
insert into products (price, name)
values (333.99, 'Подушка');

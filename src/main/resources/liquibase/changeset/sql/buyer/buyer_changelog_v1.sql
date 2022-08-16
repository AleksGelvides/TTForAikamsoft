-- Создание таблицы с покупателями
create table buyer
(
    id bigserial primary key,
    name varchar not null,
    lastname varchar not null
);

-- Наполнение таблицы с покупателями
insert into buyer (name, lastname)
values ('Андрей', 'Смирнов');
insert into buyer (name, lastname)
values ('Виктор', 'Смирнов');
insert into buyer (name, lastname)
values ('Евгений', 'Смирнов');
insert into buyer (name, lastname)
values ('Сергей', 'Смирнов');
insert into buyer (name, lastname)
values ('Евгений', 'Ширяев');
insert into buyer (name, lastname)
values ('Александр', 'Макаров');
insert into buyer (name, lastname)
values ('Елена', 'Свиридова');
insert into buyer (name, lastname)
values ('Антон', 'Гущин');
insert into buyer (name, lastname)
values ('Анастасия', 'Антонова');
insert into buyer (name, lastname)
values ('Григорий', 'Денисов');
insert into buyer (name, lastname)
values ('Юлия', 'Сергеева');
insert into buyer (name, lastname)
values ('Антонина', 'Бах');
insert into buyer (name, lastname)
values ('Виктория', 'Изотова');

-- Все имена или фамилии выдуманные и не имеют никакого отношения к реальным людям!

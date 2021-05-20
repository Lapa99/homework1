create table products (
    id bigserial primary key not null,
    title varchar,
    cost int
);
insert into products (title, cost)
values ('Альстрамерия', 120),
       ('Тюльпан', 70),
       ('Эустома', 230),
       ('Хризантема', 150),
       ('Роза', 100),
       ('Гвоздика', 60),
       ('Лилия', 450),
       ('Ирис', 70),
       ('Гербера', 120),
       ('Гипсофила', 150),
       ('Пион', 140),
       ('Ромашка', 90),
       ('Роза кустовая', 200),
       ('Маттиола', 140),
       ('Калла', 160),
       ('Гиперикум', 160),
       ('Орхидея ветка', 1600),
       ('Ферзия', 120),
       ('Целозия', 180),
       ('Дельфиниум', 160);
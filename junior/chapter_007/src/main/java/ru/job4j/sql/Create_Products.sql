create table product_type(id NUMERIC not null,
						   name TEXT not null,
						   constraint PK_PRODUCT_TYPE primary key (ID)
						 );
create table product(id NUMERIC not null,
					 name TEXT not null,
					 type_id NUMERIC not null,
					 expired_date DATE null,
					 price NUMERIC not null,
					 quantity NUMERIC not null,
					 constraint PK_PRODUCT primary key (ID)
					 );

alter table product
   add constraint FK_PRODUCT_TYPE foreign key (type_id)
      references product (ID);

insert into product_type values(1, 'СЫР');
insert into product_type values(2, 'МОЛОКО');
insert into product_type values(3, 'ХЛЕБ');
insert into product_type values(4, 'КРУПА');
insert into product_type values(5, 'ЗЕЛЕНЬ');
insert into product_type values(6, 'МЯСО');

insert into product values(1, 'Рокфор', 1, '01.08.2019 00:00:00', 50, 10);
insert into product values(2, 'Дор Блю', 1, '01.07.2019 00:00:00', 100, 17);
insert into product values(3, 'Волна', 1, '01.09.2019 00:00:00', 5, 5);
insert into product values(4, '3,5%', 2, '01.08.2019 14:02:00', 55, 5);
insert into product values(5, '2,5%', 2, '01.07.2019 00:00:00', 40, 11);
insert into product values(6, 'Черный', 3, '10.07.2019 15:00:00', 15, 100);
insert into product values(7, 'Белый', 3, '18.07.2019 00:00:00', 20, 3);
insert into product values(8, 'Пшено', 4, '01.08.2019 00:00:00', 50, 10);
insert into product values(9, 'Геркулес', 4, '01.08.2019 00:00:00', 50, 10);
insert into product values(10, 'Лук', 5, '30.07.2019 00:00:00', 30, 45);
insert into product values(11, 'Укроп', 5, '20.07.2019 00:00:00', 20, 12);
insert into product values(11, 'Мороженное сало', 6, '20.07.2019 00:00:00', 200, 10);
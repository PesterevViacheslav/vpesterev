create table car_body(id SERIAL,
						          unit_type TEXT not null
        						 );
create table car_engine(id SERIAL,
						            unit_type TEXT not null
        						   );
create table car_transmission(id SERIAL,
						                  unit_type TEXT not null
        						          );
create table car(id SERIAL not null,
                 body_id NUMERIC not null,
                 engine_id NUMERIC not null,
                 transmission_id NUMERIC not null
                 );

insert into car_body(unit_type) values('Универсал');
insert into car_body(unit_type) values('Хэтчбек');
insert into car_body(unit_type) values('Седан');
insert into car_engine(unit_type) values('Инжектор');
insert into car_engine(unit_type) values('Карбюратор');
insert into car_engine(unit_type) values('Газ');
insert into car_engine(unit_type) values('Газ-Бензин');
insert into car_transmission(unit_type) values('Автомат');
insert into car_transmission(unit_type) values('Механика');
insert into car_transmission(unit_type) values('Вариатор');
insert into car_transmission(unit_type) values('Робот');
insert into car(body_id, engine_id, transmission_id) values(1,1,1);
insert into car(body_id, engine_id, transmission_id) values(1,2,3);
insert into car(body_id, engine_id, transmission_id) values(2,1,4);
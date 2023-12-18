drop database if exists metroSystem_db;

create database metroSystem_db;

use metroSystem_db;

create table customer (
	customer_id int auto_increment ,
	email_id varchar(30),
	name varchar(30),
	creation_time time,
	constraint ps_customer_id_pk primary key ( customer_id )
);

insert into customer (customer_id, email_id, name, creation_time) values (552092, 'mmanu2176@gmail.com', 'Manoj G', '08:23:45');
insert into customer (customer_id, email_id, name, creation_time) values (552093, 'sanu@gmail.com', 'Sanath Kumar', '08:33:25');
insert into customer (customer_id, email_id, name, creation_time) values (552094, 'johns@gmail.com', 'Johnny S', '08:34:56');
insert into customer (customer_id, email_id, name, creation_time) values (552095, 'nischal@gmail.com', 'Nischal G', '09:46:15');

commit;
select * from customer;
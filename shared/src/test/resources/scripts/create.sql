create table IF NOT EXISTS USER(
	id bigint auto_increment PRIMARY KEY,
	name varchar(25) ,
	password varchar(25)
);
commit;

insert into user(name,password) values ('user','user');
insert into user(name,password) values ('admin','admin');
commit;


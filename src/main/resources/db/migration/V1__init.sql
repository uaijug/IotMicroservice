create table account (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	username varchar(255), 
	password varchar(255), 
	primary key (id)
);

create table sensor (
	id bigint(19) NOT NULL AUTO_INCREMENT,
	temperature float NOT NULL,
	humidity float NOT NULL,	
	sensor_id int NOT NULL,
	date timestamp,
	primary key (id)
);

insert into account (id, username, password) values (1, 'root', 'root');

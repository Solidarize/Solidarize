create table event ( id integer, name varchar(60), owner varchar(50), rank INTEGER);

create sequence event_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
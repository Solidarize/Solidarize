create table user ( id integer, login varchar(15), password VARCHAR(15),
type smallint);

create sequence user_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;


create table institution ( id integer, name varchar(60), cnpj VARCHAR(20),
address VARCHAR(20),
description VARCHAR(20),
password VARCHAR(10));

create sequence institution_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;


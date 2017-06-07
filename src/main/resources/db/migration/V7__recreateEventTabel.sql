drop table event;

create table event ( id integer, name TEXT, owner TEXT, rank INTEGER);

alter TABLE event add COLUMN timestamp DATE ;
alter TABLE event add COLUMN event_time DATE;
alter TABLE event add COLUMN title TEXT;
alter TABLE event add COLUMN sub_title TEXT;
alter TABLE event add COLUMN address TEXT;
alter TABLE event add COLUMN description TEXT;
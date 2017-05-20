alter TABLE event add COLUMN timestamp DATE ;
alter TABLE event add COLUMN event_time DATE;
alter TABLE event add COLUMN title VARCHAR(60);
alter TABLE event add COLUMN sub_title VARCHAR(60);
alter TABLE event add COLUMN address VARCHAR(60);
alter TABLE event add COLUMN description VARCHAR(200);
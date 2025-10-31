create sequence fruit_seq start with 1 increment by 50;
create table fruit (
  id number(10,0) not null,
  something_name nvarchar2(20) not null,
  primary key (id)
);

INSERT INTO fruit(id, something_name) VALUES (1, 'Cherry');
INSERT INTO fruit(id, something_name) VALUES (2, 'Apple');
INSERT INTO fruit(id, something_name) VALUES (3, 'Banana');
ALTER SEQUENCE fruit_seq RESTART start with 4;
create sequence known_fruits_id_seq start with 10 increment by 1;
create table known_fruits (
  id number(10,0) not null,
  something_name nvarchar2(20) not null,
  primary key (id)
);

INSERT INTO known_fruits(id, something_name) VALUES (1, 'Cherry');
INSERT INTO known_fruits(id, something_name) VALUES (2, 'Apple');
INSERT INTO known_fruits(id, something_name) VALUES (3, 'Banana');
ALTER SEQUENCE known_fruits_id_seq RESTART start with 4;
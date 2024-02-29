INSERT INTO known_fruits(id, name) VALUES (1, 'Cherry');
INSERT INTO known_fruits(id, name) VALUES (2, 'Apple');
INSERT INTO known_fruits(id, name) VALUES (3, 'Banana');
ALTER SEQUENCE known_fruits_id_seq RESTART WITH 4;

INSERT INTO animal(id) VALUES (1);
ALTER SEQUENCE animal_id_seq RESTART WITH 2;
INSERT INTO dog(id) VALUES (1);
INSERT INTO human(id, pet_id) VALUES (1, 1);
ALTER SEQUENCE human_id_seq RESTART WITH 2;

INSERT INTO author2(id, firstname, lastname) VALUES (1, 'John', 'Irving');
INSERT INTO author2(id, firstname, lastname) VALUES (2, 'Paul', 'Auster');
alter sequence Author2_SEQ restart with 2;

INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'The World According to Garp', 1);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'The Hotel New Hampshire', 1);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'The Cider House Rules', 1);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'A Prayer for Owen Meany', 1);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'Last Night in Twisted River', 1);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'In One Person', 1);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'Avenue of Mysteries', 1);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'The New York Trilogy', 2);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'Mr. Vertigo', 2);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'The Brooklyn Follies', 2);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'Invisible', 2);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), 'Sunset Park', 2);
INSERT INTO book2(id, title, author_id) VALUES (nextval('Book2_SEQ'), '4 3 2 1', 2);

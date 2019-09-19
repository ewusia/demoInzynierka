SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE new.book_author;
TRUNCATE TABLE new.book;
TRUNCATE TABLE new.author;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO new.author (author_id, name) VALUES (-1, 'adam');
INSERT INTO new.author (author_id, name) VALUES (-2, 'ewa');
INSERT INTO new.author (author_id, name) VALUES (-3, 'roman');
INSERT INTO new.author (author_id, name) VALUES (-4, 'basia');
INSERT INTO new.author (author_id, name) VALUES (-5, 'kasia');
INSERT INTO new.author (author_id, name) VALUES (-6, 'ania');
INSERT INTO new.author (author_id, name) VALUES (-7, 'kacper');
INSERT INTO new.author (author_id, name) VALUES (-8, 'kuba');
INSERT INTO new.author (author_id, name) VALUES (-9, 'darek');

INSERT INTO new.book (book_id, category, cover, title, year)
VALUES (-1, 'IT', 'hard-cover', 'Java. Podstawy', '2019');
INSERT INTO new.book (book_id, category, cover, title, year)
VALUES (-2, 'IT', 'hard-cover', 'Java. Techniki zaawansowane', '2019');
INSERT INTO new.book (book_id, category, cover, title, year)
VALUES (-3, 'IT', 'soft-cover', 'Czysty kod', '2017');
INSERT INTO new.book (book_id, category, cover, title, year)
VALUES (-4, 'Health', 'soft-cover', 'Dieta Dąbrowskiej', '2018');


INSERT  INTO new.book_author(book_id, author_id) VALUES (-1,-1);
INSERT  INTO new.book_author(book_id, author_id) VALUES (-2,-1);
INSERT  INTO new.book_author(book_id, author_id) VALUES (-2,-2);
INSERT  INTO new.book_author(book_id, author_id) VALUES (-3,-1);
INSERT  INTO new.book_author(book_id, author_id) VALUES (-4,-3);

commit;


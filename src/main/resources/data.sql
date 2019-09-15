TRUNCATE TABLE new.book;

INSERT INTO new.book (id, author, category, cover, title, year)
VALUES (-1, 'Cay S. Horstmann', 'IT', 'hard-cover', 'Java. Podstawy', '2019');
INSERT INTO new.book (id, author, category, cover, title, year)
VALUES (-2, 'Cay S. Horstmann', 'IT', 'hard-cover', 'Java. Techniki zaawansowane', '2019');
INSERT INTO new.book (id, author, category, cover, title, year)
VALUES (-3, 'Robert C. Martin', 'IT', 'soft-cover', 'Czysty kod', '2017');
INSERT INTO new.book (id, author, category, cover, title, year)
VALUES (-4, 'Ewa Dąbrowska', 'Health', 'soft-cover', 'Dieta Dąbrowskiej', '2018');

commit;


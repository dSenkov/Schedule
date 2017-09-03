DELETE FROM exams;
ALTER SEQUENCE exams_id_seq RESTART WITH 1;
DELETE FROM lessons_groups;
DELETE FROM lessons;
ALTER SEQUENCE lessons_id_seq RESTART WITH 1;
DELETE FROM teachers;
ALTER SEQUENCE teachers_id_seq RESTART WITH 1;
DELETE FROM groups;
ALTER SEQUENCE groups_id_seq RESTART WITH 1;
DELETE FROM facultys;
ALTER SEQUENCE facultys_id_seq RESTART WITH 1;
DELETE FROM users;
ALTER SEQUENCE users_id_seq RESTART WITH 1;

INSERT INTO users (login, password, name, role)
VALUES ('user.login', 'user.password', 'UzeRRR', 0);
INSERT INTO users (login, password, name, role)
VALUES ('moder.login', 'moder.password', 'ModeRRR', 1);
INSERT INTO users (login, password, name, role)
VALUES ('admin.login', 'admin.password', 'AdMiN', 2);

INSERT INTO facultys (name) VALUES ('ФИВТ');
INSERT INTO facultys (name) VALUES ('ИПСА');
INSERT INTO facultys (name) VALUES ('ФПМ');
INSERT INTO facultys (name) VALUES ('ФТИ');
INSERT INTO facultys (name) VALUES ('ИТС');

INSERT INTO teachers (name, rank)
VALUES ('Репникова Наталья Борисовна', 'доцент');
INSERT INTO teachers (name, rank)
VALUES ('Новацкий Анатолий Александрович', 'доцент');
INSERT INTO teachers (name, rank)
VALUES ('Жеребко Валерий Анатольевич', 'ст. преп.');
INSERT INTO teachers (name, rank)
VALUES ('Дорошенко Екатерина Сергеевна', 'ст. преп.');
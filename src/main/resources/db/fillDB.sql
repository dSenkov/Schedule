DELETE FROM lessons_groups;
DELETE FROM lessons;
ALTER SEQUENCE lessons_id_seq RESTART WITH 1;
DELETE FROM groups;
ALTER SEQUENCE groups_id_seq RESTART WITH 1;
DELETE FROM facultys;
ALTER SEQUENCE facultys_id_seq RESTART WITH 1;

INSERT INTO facultys (name) VALUES ('ФАКС');
INSERT INTO facultys (name) VALUES ('ТЭФ');
INSERT INTO facultys (name) VALUES ('ФСП');
INSERT INTO facultys (name) VALUES ('ФБМИ');
INSERT INTO facultys (name) VALUES ('ММИ');
INSERT INTO facultys (name) VALUES ('ФПМ');
INSERT INTO facultys (name) VALUES ('ФММ');
INSERT INTO facultys (name) VALUES ('ФМФ');
INSERT INTO facultys (name) VALUES ('ФБТ');
INSERT INTO facultys (name) VALUES ('ХТФ');
INSERT INTO facultys (name) VALUES ('ФЛ');
INSERT INTO facultys (name) VALUES ('ФИВТ');
INSERT INTO facultys (name) VALUES ('ФЭЛ');
INSERT INTO facultys (name) VALUES ('ФЭА');
INSERT INTO facultys (name) VALUES ('РТФ');
INSERT INTO facultys (name) VALUES ('ПСФ');
INSERT INTO facultys (name) VALUES ('ИХФ');
INSERT INTO facultys (name) VALUES ('СФ');
INSERT INTO facultys (name) VALUES ('ИФФ');
INSERT INTO facultys (name) VALUES ('ИПСА');
INSERT INTO facultys (name) VALUES ('ИТС');
INSERT INTO facultys (name) VALUES ('ИПИ');
INSERT INTO facultys (name) VALUES ('ИЭЭ');
INSERT INTO facultys (name) VALUES ('ИССЗИ');
INSERT INTO facultys (name) VALUES ('ФТИ');


INSERT INTO groups (faculty_id, name, course)
VALUES (1, 'ИА-51', 3);
INSERT INTO groups (faculty_id, name, course)
VALUES (1, 'ИА-52', 3);
INSERT INTO groups (faculty_id, name, course)
VALUES (1, 'ИП-71', 1);
INSERT INTO groups (faculty_id, name, course)
VALUES (1, 'ИП-72', 1);
INSERT INTO groups (faculty_id, name, course)
VALUES (2, 'ИПСА-61', 2);
INSERT INTO groups (faculty_id, name, course)
VALUES (2, 'ИПСА-62', 2);
INSERT INTO groups (faculty_id, name, course)
VALUES (2, 'ИПСА-44', 4);


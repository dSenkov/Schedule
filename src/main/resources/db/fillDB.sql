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
VALUES (12, 'ИА-51', 3);
INSERT INTO groups (faculty_id, name, course)
VALUES (12, 'ИА-52', 3);
INSERT INTO groups (faculty_id, name, course)
VALUES (12, 'ИП-71', 1);
INSERT INTO groups (faculty_id, name, course)
VALUES (12, 'ИП-72', 1);
INSERT INTO groups (faculty_id, name, course)
VALUES (20, 'ИПСА-61', 2);
INSERT INTO groups (faculty_id, name, course)
VALUES (20, 'ИПСА-62', 2);
INSERT INTO groups (faculty_id, name, course)
VALUES (20, 'ИПСА-44', 4);

INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 0, 2, 'Основы ТАУ', 'Репникова Н. Б.', 'LECTURE', 18, 307, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 0, 3, 'Комп. электр. 2', 'Новацкий А. А.', 'LECTURE', 18, 307, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 0, 4, 'Комп. электр. 2', 'Новацкий А. А.', 'LAB', 18, 517, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 2, 1, 'Мод. проц. и сист.', 'Жеребко В. А.', 'LECTURE', 18, 307, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 2, 2, 'Мод. проц. и сист.', 'Жеребко В. А.', 'PRACTISE', 18, 309, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 2, 3, 'Основы ТАУ', 'Репникова Н. Б.', 'LAB', 18, 534, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 2, 4, 'Комп. крипт.', 'Дорошенко Е. С.', 'LAB', 18, 533, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 3, 3, 'СТП-2', 'Хмелюк М. С.', 'LAB', 18, 517, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 3, 4, 'ОТИП-1', 'Моргаль О. М.', 'LAB', 18, 517, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 4, 1, 'Экономика-1', 'Шевчук Е. А.', 'LECTURE', 18, 306, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 4, 2, 'СТП-2', 'Амонс А. А.', 'LECTURE', 18, 306, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 4, 3, 'Комп. крипт.', 'Полторак В. П.', 'LECTURE', 18, 306, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (TRUE, 4, 4, 'Англ. язык', 'Бондаренко А. И.', 'PRACTISE', 18, 531, 1);

INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE , 0, 2, 'Основы ТАУ', 'Репникова Н. Б.', 'LECTURE', 18, 307, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE , 0, 3, 'Комп. электр. 2', 'Новацкий А. А.', 'LECTURE', 18, 307, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 2, 1, 'Мод. проц. и сист.', 'Жеребко В. А.', 'LECTURE', 18, 307, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 2, 2, 'Экономика-1', 'Шевчук Е. А.', 'PRACTISE', 18, 231, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 2, 3, 'Основы ТАУ', 'Репникова Н. Б.', 'LAB', 18, 534, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 2, 4, 'Комп. крипт.', 'Дорошенко Е. С.', 'LAB', 18, 533, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 3, 2, 'ОТИП-1', 'Моргаль О. М.', 'LECTURE', 18, 307, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 3, 3, 'СТП-2', 'Хмелюк М. С.', 'LAB', 18, 517, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 4, 2, 'СТП-2', 'Амонс А. А.', 'LECTURE', 18, 306, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 4, 3, 'Комп. крипт.', 'Полторак В. П.', 'LECTURE', 18, 306, 1);
INSERT INTO lessons (firstweek, day, number, subject, teacher, type, building, classroom, group_id)
VALUES (FALSE, 4, 4, 'Англ. язык', 'Бондаренко А. И.', 'PRACTISE', 18, 531, 1);


CREATE TABLE users (
  id          SERIAL PRIMARY KEY,
  login       TEXT NOT NULL UNIQUE,
  password    TEXT NOT NULL,
  name        TEXT NOT NULL,
  role        INTEGER NOT NULL
);

CREATE TABLE facultys (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL UNIQUE
);

CREATE TABLE groups (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL UNIQUE,
  course      INTEGER NOT NULL,
  faculty_id  INTEGER NOT NULL,
  FOREIGN KEY (faculty_id) REFERENCES facultys (id) ON DELETE CASCADE
);

CREATE TABLE teachers (
  id          SERIAL PRIMARY KEY,
  name        TEXT NOT NULL,
  rank        TEXT NOT NULL
);

CREATE TABLE exams (
  id          SERIAL PRIMARY KEY,
  subject     TEXT NOT NULL,
  datetime    TIMESTAMP WITH TIME ZONE NOT NULL,
  building    INTEGER NOT NULL,
  classroom   INTEGER NOT NULL,
  group_id    INTEGER NOT NULL,
  teacher_id  INTEGER NOT NULL,
  FOREIGN KEY (group_id)    REFERENCES groups   (id) ON DELETE CASCADE,
  FOREIGN KEY (teacher_id)  REFERENCES teachers (id) ON DELETE CASCADE
);

CREATE TABLE lessons (
  id          SERIAL PRIMARY KEY,
  firstweek   BOOLEAN NOT NULL,
  day         TEXT NOT NULL,
  number      INTEGER NOT NULL,
  subject     INTEGER NOT NULL,
  type        TEXT NOT NULL,
  building    INTEGER NOT NULL,
  classroom   INTEGER NOT NULL,
  teacher_id  INTEGER NOT NULL,
  FOREIGN KEY (teacher_id)  REFERENCES teachers (id) ON DELETE CASCADE
);

CREATE TABLE lessons_groups (
  lesson_id   INTEGER NOT NULL,
  group_id    INTEGER NOT NULL,
  FOREIGN KEY (lesson_id) REFERENCES lessons  (id) ON DELETE CASCADE,
  FOREIGN KEY (group_id)  REFERENCES groups   (id) ON DELETE CASCADE
);

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



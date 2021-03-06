DROP TABLE IF EXISTS lessons;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS facultys;

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

CREATE TABLE lessons (
  id          SERIAL PRIMARY KEY,
  firstweek   BOOLEAN NOT NULL,
  day         INTEGER NOT NULL,
  number      INTEGER NOT NULL,
  subject     TEXT NOT NULL,
  teacher     TEXT NOT NULL,
  type        TEXT NOT NULL,
  building    INTEGER NOT NULL,
  classroom   INTEGER NOT NULL,
  group_id    INTEGER NOT NULL,
  FOREIGN KEY (group_id) REFERENCES groups (id) ON DELETE CASCADE
);






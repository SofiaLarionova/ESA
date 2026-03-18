DROP DATABASE IF EXISTS models_books;
CREATE DATABASE models_books;

DROP TABLE IF EXISTS models;
DROP TABLE IF EXISTS books;

DROP INDEX IF EXISTS models_name_uindex;
DROP INDEX IF EXISTS books_title_uindex;

DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START WITH 100000;

-- Таблица для моделей компьютерного зрения
CREATE TABLE models
(
    id           bigint PRIMARY KEY DEFAULT nextval('global_seq'),
    model_name   VARCHAR(255) NOT NULL, -- Название модели
    release_date DATE DEFAULT NOW(),    -- Дата появления модели
    top5_score   DECIMAL(5, 4)          -- Top5 score (точность модели на ImageNet)
);

CREATE UNIQUE INDEX models_name_uindex ON models (model_name);

-- Таблица для книг Стивена Кинга
CREATE TABLE books
(
    id     bigint PRIMARY KEY DEFAULT nextval('global_seq'),
    title  VARCHAR(255) NOT NULL,
    genre  VARCHAR(100),
    year   INT,
    rating DECIMAL(3, 1)
);

CREATE UNIQUE INDEX books_title_uindex ON books (title);
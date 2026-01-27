DROP DATABASE IF EXISTS models_books;
CREATE DATABASE models_books;

DROP TABLE IF EXISTS tables;
DROP TABLE IF EXISTS stephen_king_books;

DROP INDEX IF EXISTS models_name_uindex;
DROP INDEX IF EXISTS stephen_king_books_title_uindex;

-- Таблица для моделей компьютерного зрения
CREATE TABLE models
(
    id           serial PRIMARY KEY,
    model_name   VARCHAR(255) NOT NULL, -- Название модели
    release_date DATE DEFAULT NOW(),    -- Дата появления модели
    top5_score   DECIMAL(5, 4)          -- Top5 score (точность модели на ImageNet)
);

CREATE UNIQUE INDEX models_name_uindex ON models (model_name);

INSERT INTO models (model_name, release_date, top5_score)
VALUES ('AlexNet', '2012-09-30', 0.6324),
       ('VGG16', '2014-09-01', 0.7152),
       ('ResNet-50', '2015-12-01', 0.7497),
       ('InceptionV3', '2015-10-01', 0.7690),
       ('DenseNet-121', '2017-03-01', 0.7480),
       ('Xception', '2016-09-01', 0.7900),
       ('MobileNetV2', '2018-01-01', 0.7100),
       ('EfficientNetB0', '2019-06-01', 0.8240);

-- Таблица для книг Стивена Кинга
CREATE TABLE stephen_king_books
(
    id     serial PRIMARY KEY,
    title  VARCHAR(255) NOT NULL,
    genre  VARCHAR(100),
    year   INT,
    rating DECIMAL(3, 1)
);

CREATE UNIQUE INDEX stephen_king_books_title_uindex ON stephen_king_books (title);


INSERT INTO stephen_king_books (title, genre, year, rating)
VALUES ('The Shining', 'Horror', 1977, 4.8),
       ('It', 'Horror', 1986, 4.7),
       ('Carrie', 'Horror', 1974, 4.5),
       ('The Dark Tower', 'Fantasy', 1982, 4.6),
       ('Misery', 'Thriller', 1987, 4.6),
       ('The Stand', 'Apocalypse', 1978, 4.7),
       ('Doctor Sleep', 'Horror', 2013, 4.5),
       ('The Green Mile', 'Drama', 1996, 4.8);
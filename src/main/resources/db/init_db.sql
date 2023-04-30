CREATE SCHEMA IF NOT EXISTS homework;

CREATE TABLE homework.weather
(
    id   SERIAL PRIMARY KEY,
    city varchar(50),
    temperature varchar(20),
    condition varchar(256)
);

INSERT INTO homework.weather (city, temperature, condition)
VALUES
    ('test1_city', 'test1_temperature', 'test1_condition'),
    ('test2_city', 'test2_temperature', 'test2_condition'),
    ('test3_city', 'test3_temperature', 'test3_condition');

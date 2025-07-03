DROP table if exists products;

CREATE TABLE if not exists products (
id Serial primary key,
brand VARCHAR(100),
model VARCHAR(100),
colour VARCHAR(100),
capacity INTEGER,
price NUMERIC(10,2),
year_of_manufacture DATE,
discount NUMERIC(5, 2));
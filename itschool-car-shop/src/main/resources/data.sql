-- 1. Addresses
INSERT INTO addresses (street, city, country) VALUES
  ('Str. Copou',   'Iași',     'Romania'),
  ('Str. Libertății 10',  'Cluj-Napoca',   'Romania'),
  ('Bd. Unirii 15',       'Timișoara',     'Romania'),
  ('Str. Primăverii 1',     'București',        'Romania');

-- 2. Customers
INSERT INTO customers (name, email, address_id) VALUES
  ('Andrei Popescu',   'andrei@example.com', 1),
  ('Ioana Ionescu',    'ioana@example.com',  2),
  ('Mihai Georgescu',  'mihai@example.com',  3),
  ('Elena Vasilescu',  'elena@example.com',  4);

-- 3. Products
INSERT INTO products (brand, model, colour, capacity, price, year_of_manufacture, discount) VALUES
  ('Dacia',    'Logan',   'blue',   1, 15000.00, '2019-03-15', 5.00),
  ('Ford',     'Focus',   'black',  2, 20000.00, '2020-07-20', 10.00),
  ('Renault',  'Clio',    'red',    1, 17000.00, '2018-05-10', 7.50),
  ('VW',       'Passat',  'grey',   2, 22000.00, '2021-02-28', 12.00),
  ('Toyota',   'Corolla','white',  1, 18000.00, '2017-11-05', 8.00),
  ('Mercedes','C300',    'silver', 3, 35000.00, '2022-08-12', 15.00);

-- 4. Orders
INSERT INTO orders (customer_id, order_date) VALUES
  (1, '2024-06-01'),
  (2, '2024-06-15'),
  (3, '2024-07-01'),
  (1, '2024-07-05'),
  (4, '2024-07-10');

-- 5. Order-Products (many-to-many relationships)
INSERT INTO order_products (order_id, product_id) VALUES
  (1, 1), (1, 2),          -- Andrei ordered Logan & Focus
  (2, 3),                  -- Ioana ordered Clio
  (3, 2), (3, 4), (3, 6),  -- Mihai ordered Focus, Passat, C300
  (4, 5),                  -- Andrei ordered Corolla
  (5, 1), (5, 6);          -- Elena ordered Logan & C300
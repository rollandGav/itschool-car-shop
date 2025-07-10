-- Drop existing tables in dependency order
DROP TABLE IF EXISTS order_products CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS addresses CASCADE;

-- Create addresses table
CREATE TABLE addresses (
  id SERIAL PRIMARY KEY,
  street VARCHAR(255) NOT NULL,
  city VARCHAR(100) NOT NULL,
  country VARCHAR(100) NOT NULL
);

-- Create customers table
CREATE TABLE customers (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  email VARCHAR(200) UNIQUE NOT NULL,
  address_id INTEGER NOT NULL REFERENCES addresses(id) ON DELETE CASCADE
);

-- Create products table
CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  brand VARCHAR(100),
  model VARCHAR(100),
  colour VARCHAR(50),
  capacity INTEGER,
  price DECIMAL(10,2),
  year_of_manufacture DATE,
  discount DECIMAL(5,2) NOT NULL
);

-- Create orders table
CREATE TABLE orders (
  id SERIAL PRIMARY KEY,
  customer_id INTEGER NOT NULL REFERENCES customers(id) ON DELETE CASCADE,
  order_date DATE
);

-- Create join table for Order ↔ Product many-to-many
CREATE TABLE order_products (
  order_id INTEGER NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
  product_id INTEGER NOT NULL REFERENCES products(id) ON DELETE CASCADE,
  PRIMARY KEY (order_id, product_id)
);
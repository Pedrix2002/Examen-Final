CREATE DATABASE tienda_computadoras;

USE tienda_computadoras;

CREATE TABLE computadoras (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    precio DECIMAL(10, 2),
    cantidad INT,
    marca VARCHAR(50)
);

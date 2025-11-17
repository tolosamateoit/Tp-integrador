-- Script SQL para crear la base de datos y tabla
-- Ejecutar en MySQL desde línea de comandos o cliente gráfico

-- Crear base de datos
CREATE DATABASE IF NOT EXISTS demo_jpa;

-- Usar la base de datos
USE demo_jpa;

-- Crear tabla producto
CREATE TABLE IF NOT EXISTS producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(500),
    precio DOUBLE NOT NULL
);

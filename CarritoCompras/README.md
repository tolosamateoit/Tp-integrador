# CarritoCompras - Proyecto Académico

Aplicación web completa desarrollada con Spring Boot 3.5, Spring Data JPA, MySQL y Thymeleaf.

## Estructura del Proyecto

```
CarritoCompras/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/ecommerce/carritocompras/
│   │   │       ├── modelo/
│   │   │       │   └── Producto.java
│   │   │       ├── repositorio/
│   │   │       │   └── ProductoRepositorio.java
│   │   │       ├── servicio/
│   │   │       │   └── ProductoServicio.java
│   │   │       ├── controlador/
│   │   │       │   └── ProductoControlador.java
│   │   │       └── CarritoComprasApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── productos.html
│   │       └── application.properties
│   └── test/
├── pom.xml
├── DATABASE_SETUP.sql
└── README.md
```

## Requisitos Previos

- Java 17 o superior
- Maven 3.8.0 o superior
- MySQL 8.0 o superior

## Configuración de la Base de Datos

### Opción 1: Usando MySQL Cliente desde Línea de Comandos

```cmd
mysql -u root -p < DATABASE_SETUP.sql
```

### Opción 2: Usando MySQL Workbench o Cliente Gráfico

1. Abrir el cliente MySQL
2. Copiar y ejecutar el contenido de `DATABASE_SETUP.sql`

### Opción 3: Ejecutar los comandos SQL manualmente

```sql
CREATE DATABASE IF NOT EXISTS demo_jpa;
USE demo_jpa;

CREATE TABLE IF NOT EXISTS producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(500),
    precio DOUBLE NOT NULL
);

INSERT INTO producto (nombre, descripcion, precio) VALUES
('Laptop Dell', 'Laptop de 15.6 pulgadas, procesador Intel i7', 1200.00),
('Mouse Logitech', 'Mouse inalámbrico USB', 35.50),
('Teclado Mecánico', 'Teclado RGB con switches Cherry MX', 125.00),
('Monitor LG', 'Monitor 27 pulgadas 4K', 450.00),
('Auriculares Sony', 'Auriculares inalámbricos con cancelación de ruido', 299.99),
('Webcam HD', 'Webcam 1080p con micrófono integrado', 79.99);
```

## Instalar Dependencias

```cmd
mvn clean install
```

## Ejecutar la Aplicación

### Desde la línea de comandos:

```cmd
mvn spring-boot:run
```

### Desde IDE (IntelliJ IDEA, Eclipse, VS Code):

1. Click derecho en `CarritoComprasApplication.java`
2. Seleccionar "Run" o "Debug"

La aplicación se ejecutará en: **http://localhost:8080**

## Acceder a la Aplicación

Abrir el navegador web y dirigirse a:

```
http://localhost:8080/productos
```

Verá una tabla con todos los productos de la base de datos.

## Tecnologías Utilizadas

- **Spring Boot 3.5**: Framework web
- **Spring Data JPA**: Acceso a datos
- **MySQL 8.0**: Base de datos
- **Thymeleaf**: Motor de plantillas HTML
- **Maven**: Gestor de dependencias

## Componentes del Proyecto

### 1. **Modelo (Producto.java)**
- Entidad JPA mapeada a tabla `producto`
- Atributos: id, nombre, descripcion, precio

### 2. **Repositorio (ProductoRepositorio.java)**
- Interfaz que extiende JpaRepository<Producto, Long>
- Proporciona métodos CRUD automáticos

### 3. **Servicio (ProductoServicio.java)**
- Lógica de negocio
- Método: `obtenerTodosLosProductos()`

### 4. **Controlador (ProductoControlador.java)**
- Maneja rutas HTTP
- Ruta GET: `/productos`

### 5. **Vista (productos.html)**
- Plantilla Thymeleaf
- Tabla con columnas: ID, Nombre, Descripción, Precio

## Configuración de Conexión

El archivo `application.properties` contiene:

```properties
spring.application.name=CarritoCompras
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/demo_jpa
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jmx.enabled=false
```

**Nota**: Si la contraseña de MySQL es diferente, modificar `spring.datasource.password`

## Troubleshooting

### Error: "Connection refused"
- Verificar que MySQL está corriendo
- Verificar que la base de datos `demo_jpa` existe

### Error: "Table 'demo_jpa.producto' doesn't exist"
- Ejecutar el script SQL nuevamente

### Error de dependencias Maven
- Ejecutar: `mvn clean install -U`

## Autor

Proyecto Académico - Taller de Construcción de Software

## Licencia

MIT

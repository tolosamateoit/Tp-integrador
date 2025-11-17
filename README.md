# 🛒 CarritoCompras - Sistema de Gestión de Productos

**Proyecto Académico - Taller de Construcción de Software | Universidad Siglo XXI**

## 📋 Descripción del Proyecto

**CarritoCompras** es una aplicación web desarrollada en **Spring Boot 3.5** con **Thymeleaf** que permite gestionar un catálogo de productos. El sistema implementa un **CRUD completo** (Create, Read, Update, Delete) con persistencia de datos en **MySQL**.

### Características Principales

✅ **CRUD Completo**
- ➕ Crear nuevos productos
- 📋 Listar todos los productos
- ✏️ Editar productos existentes
- 🗑️ Eliminar productos 

✅ **Funcionalidades Avanzadas**
- 🔍 Búsqueda de productos por nombre
- 🚫 Validación de precios (no negativos)
- 📊 Ordenamiento de productos (por ID, nombre, precio ascendente/descendente)
- 💾 Persistencia de datos en base de datos MySQL

✅ **Interfaz Amigable**
- Diseño responsivo (mobile-first)
- Gradientes y estilos modernos
- Mensajes de éxito/error interactivos
- Confirmaciones antes de eliminar

---

## 🚀 Instrucciones de Instalación

### Paso 1: Clonar el Repositorio

```bash
git clone https://github.com/tolosamateoit/Tp-integrador.git
```

### Paso 2: instalar docker
```bash
https://www.docker.com/products/docker-desktop/
```

### Paso 3: Ejecutar el Proyecto con Docker 🐳

El proyecto está configurado por defecto con:
- **Usuario:** `root`
- **Contraseña:** `admin`

El proyecto incluye:

Un contenedor MySQL

Un contenedor con la aplicación Spring Boot

Un archivo .env con las variables necesarias


Para iniciar todo, abra la terminal cmd, posicionandose en la carpeta raiz del proyecto .../Tp-integrador/CarritoCompras
y ejecute el comando:
```bash
docker-compose up --build

```


Este comando:

-Descarga las imágenes necesarias

-Construye la imagen del proyecto

-Crea la base de datos automáticamente

-Inicia la aplicación

Cuando vea:

"Started CarritoComprasApplication"

la app ya está funcionando.


### Paso 4: 🌐 Acceder a la Aplicación

Ingresar desde el navegador a:
```bash
http://localhost:8080/productos
```

¡Listo! 🎉 La aplicación debe estar funcionando.

---

## 💻 Cómo Usar la Aplicación

### Crear un Producto

1. Haz clic en el botón **"➕ Nuevo Producto"**
2. Completa los campos:
   - **Nombre** (obligatorio)
   - **Descripción** (opcional)
   - **Precio** (obligatorio, debe ser ≥ 0)
3. Haz clic en **"➕ Crear Producto"**

### Buscar Productos

1. En la barra de búsqueda, ingresa el nombre del producto
2. Haz clic en **"Buscar"**
3. Para volver a la lista completa, haz clic en **"Limpiar"**

### Ordenar Productos

1. En el selector "Ordenar por", elige una opción:
   - **ID**: Orden por ID (por defecto)
   - **Nombre (A-Z)**: Orden alfabético
   - **Precio (Menor a Mayor)**: Orden ascendente por precio
   - **Precio (Mayor a Menor)**: Orden descendente por precio
2. La lista se actualiza automáticamente

### Editar un Producto

1. En la tabla, localiza el producto
2. Haz clic en el botón **"✏️ Editar"**
3. Modifica los datos que desees
4. Haz clic en **"💾 Guardar Cambios"**

### Eliminar un Producto

1. En la tabla, localiza el producto
2. Haz clic en el botón **"🗑️ Eliminar"**
3. Confirma la acción en el diálogo que aparece
4. El producto será eliminado (soft delete)

---

## 🏗️ Estructura del Proyecto

```
CarritoCompras/
├── src/
│   ├── main/
│   │   ├── java/com/ecommerce/carritocompras/
│   │   │   ├── modelo/
│   │   │   │   └── Producto.java              # Entidad JPA
│   │   │   ├── dto/
│   │   │   │   └── ProductoDTO.java           # Objeto de transferencia
│   │   │   ├── repositorio/
│   │   │   │   └── ProductoRepositorio.java    # Interfaz de acceso a datos
│   │   │   ├── servicio/
│   │   │   │   ├── ProductoServicioInterface.java
│   │   │   │   └── ProductoServicio.java      # Lógica de negocio
│   │   │   ├── usecase/
│   │   │   │   ├── CrearProductoUseCase.java
│   │   │   │   ├── ActualizarProductoUseCase.java
│   │   │   │   └── EliminarProductoUseCase.java
│   │   │   ├── mapper/
│   │   │   │   └── ProductoMapper.java         # Conversión Entidad <-> DTO
│   │   │   ├── exception/
│   │   │   │   └── ExceptionHandler.java      # Manejo centralizado de errores
│   │   │   ├── controlador/
│   │   │   │   └── ProductoControlador.java  # Controlador MVC
│   │   │   ├── util/
│   │   │   │   └── Constantes.java            # Constantes del sistema
│   │   │   └── CarritoComprasApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── templates/
│   │   │       └── productos.html
│   │   └── webapp/
│   └── test/
├── pom.xml
├── README.md
├── Dockerfile
├── docker-compose.yml
└── .env
```

### Organización del Código

El proyecto está organizado en capas siguiendo una arquitectura en capas:

- **Controlador**: Maneja las peticiones HTTP y delega al servicio
- **Servicio**: Orquesta los casos de uso y coordina la lógica de negocio
- **UseCase**: Encapsula operaciones específicas (crear, actualizar, eliminar)
- **Repositorio**: Acceso a la base de datos mediante Spring Data JPA
- **DTO**: Objetos de transferencia que separan la entidad de la capa de presentación
- **Mapper**: Convierte entre entidades JPA y DTOs
- **Exception Handler**: Maneja excepciones de forma centralizada

---

## 🔧 Tecnologías Utilizadas

| Tecnología        | Versión            | Propósito                     |
|-------------------|--------------------|-------------------------------|
| Spring Boot       | 3.5.0              | Framework principal           |
| Spring Data JPA   | 3.5.0              | ORM y acceso a datos          |
| Hibernate         | 6.6.15.Final       | ORM                           |
| Thymeleaf         | 3.1.3.RELEASE      | Motor de plantillas           |
| MySQL             | 8.0+               | Base de datos                 |
| Maven             | 3.x                | Build automation              |
| Java              | 17+                | Lenguaje de programación      |
| Docker            | Latest             | Contenerización del proyecto  |

---

## 📝 Notas Importantes

### Validaciones Implementadas

- ✅ **Precio:** No puede ser negativo (validación HTML + servidor)
- ✅ **Nombre:** Campo obligatorio
- ✅ **Búsqueda:** Diferencia entre "sin resultados" y "lista vacía"

### Persistencia de Datos

- 📊 Los datos se guardan automáticamente en MySQL
- 🔄 Si reinicia la aplicación, los datos se mantienen
- 🗂️ La tabla se crea automáticamente en el primer inicio

### Eliminación Segura

- 🔒 La eliminación es "lógica" (soft delete) - los datos no se borran, solo se marcan como inactivos
- ✏️ Los productos eliminados no aparecen en la lista, pero los datos permanecen en la BD

### Timestamps Automáticos

- Los campos `created_at` y `updated_at` se establecen automáticamente mediante anotaciones JPA
- `created_at` se asigna al crear el producto
- `updated_at` se actualiza cada vez que se modifica el producto

---

## ❓ Solución de Problemas

### "Puerto 8080 ya está en uso"
```bash
# En PowerShell/CMD:
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### "Conexión rechazada a MySQL"
- Verifica que MySQL esté ejecutándose
- Confirma que la contraseña en `application.properties` es correcta
- Asegúrate de que la base de datos `demo_jpa` existe

### "Compilación fallida"
- Ejecuta `mvn clean install`
- Verifica que Java 17+ esté instalado
- Elimina la carpeta `target` y reintas

---

## 👥 Equipo
Desarrolladores:
Tolosa Mateo
Luciano Agustin Guzmán Ortega
Ramiro Berardo

Profesor: Pablo Daniel Sandoval

**Proyecto Académico - Taller de Construcción de Software** - Catedra B
- Universidad Siglo XXI - 2025 - Segundo cuatrimestre - Subperiodo B

---

## 📄 Licencia

Este proyecto es de código abierto y puede ser utilizado con propósitos educativos.

---

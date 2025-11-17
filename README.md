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
- 📊 Ordenamiento de productos por ID
- 💾 Persistencia de datos en base de datos MySQL

✅ **Interfaz Amigable**
- Diseño responsivo (mobile-first)
- Gradientes y estilos modernos
- Mensajes de éxito/error interactivos
- Confirmaciones antes de eliminar

---

## 📦 Requisitos Previos

Antes de instalar el proyecto, asegúrate de tener instalado en tu computadora:

### Software Requerido

| Requisito | Versión | Descarga |
|-----------|---------|----------|
| **Java JDK** | 17 o superior | [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/) |
| **Maven** | 3.8+ | [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi) |
| **MySQL** | 8.0+ | [https://www.mysql.com/downloads/](https://www.mysql.com/downloads/) |
| **Git** | Cualquier versión | [https://git-scm.com/](https://git-scm.com/) |

### Verificar Instalaciones

Abre una terminal/PowerShell y ejecuta:

```bash
# Verificar Java
java -version

# Verificar Maven
mvn -version

# Verificar MySQL
mysql --version

# Verificar Git
git --version
```

---

## 🚀 Instrucciones de Instalación

### Paso 1: Clonar el Repositorio

```bash
git clone https://github.com/tolosamateoit/Tp-integrador.git
cd Tp-integrador/CarritoCompras
```

### Paso 2: Crear la Base de Datos MySQL

Abre MySQL en tu terminal:

```bash
mysql -u root -p
```

Ingresa tu contraseña de MySQL y luego ejecuta:

```sql
CREATE DATABASE demo_jpa;
USE demo_jpa;
```

### Paso 3: Configurar la Contraseña de MySQL

El proyecto está configurado por defecto con:
- **Usuario:** `root`
- **Contraseña:** `admin`

**Si tu contraseña es diferente**, edita el archivo:
```
CarritoCompras/src/main/resources/application.properties
```

Y cambia la línea:
```properties
spring.datasource.password=admin
```

Por tu contraseña actual.

### Paso 4: Compilar el Proyecto

En la terminal (dentro de la carpeta `CarritoCompras`), ejecuta:

```bash
mvn clean compile -DskipTests
```

Este comando:
- Limpia compilaciones anteriores (`clean`)
- Compila todo el código (`compile`)
- Omite las pruebas (`-DskipTests`)

**Resultado esperado:** Deberías ver `BUILD SUCCESS`

### Paso 5: Ejecutar la Aplicación

```bash
mvn spring-boot:run
```

Espera a que veas el mensaje:
```
Tomcat started on port 8080 (http) with context path '/'
Started CarritoComprasApplication in X.XXX seconds
```

### Paso 6: Acceder a la Aplicación

Abre tu navegador web y ve a:

```
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
│   │   │   │   └── Producto.java           # Entidad JPA
│   │   │   ├── repositorio/
│   │   │   │   └── ProductoRepositorio.java # Data Access Layer
│   │   │   ├── servicio/
│   │   │   │   └── ProductoServicio.java    # Business Logic
│   │   │   ├── controlador/
│   │   │   │   └── ProductoControlador.java # HTTP Endpoints
│   │   │   └── CarritoComprasApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties       # Configuración
│   │   │   └── templates/
│   │   │       └── productos.html           # Vista Thymeleaf
│   │   └── webapp/
│   └── test/
├── pom.xml                                   # Dependencias Maven
└── README.md
```

---

## 🔧 Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|----------|
| Spring Boot | 3.5.0 | Framework principal |
| Spring Data JPA | 3.5.0 | ORM y acceso a datos |
| Hibernate | 6.6.15.Final | ORM |
| Thymeleaf | 3.1.3.RELEASE | Motor de plantillas |
| MySQL | 8.0+ | Base de datos |
| Maven | 3.x | Build automation |
| Java | 17+ | Lenguaje de programación |

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

## 🎯 Próximas Mejoras (Propuestas)

- [ ] Agregar categorías de productos
- [ ] Sistema de carrito de compras
- [ ] Autenticación de usuarios
- [ ] Filtrado por precio
- [ ] Cargar imágenes de productos
- [ ] API REST JSON
- [ ] Paginación avanzada
- [ ] Historial de cambios

---

**¡Gracias por usar CarritoCompras!** 🎉

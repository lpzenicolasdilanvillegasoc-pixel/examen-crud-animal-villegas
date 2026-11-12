
# Examen CRUD Animal

API REST desarrollada con Java 21 y Spring Boot 3.

## Tecnologías
- Java 21
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman

## Ejecución

En Windows:

```bash
.\mvnw.cmd spring-boot:run
```

## Base de datos H2

Consola: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:animalesdb

Usuario: sa

Contraseña: (vacía)

## Endpoints

| Método | Ruta | Acción |
|---|---|---|
| POST | /api/animales | Crear animal |
| GET | /api/animales | Listar animales |
| GET | /api/animales/{id} | Buscar animal |
| PUT | /api/animales/{id} | Actualizar animal |
| DELETE | /api/animales/{id} | Eliminar lógicamente |

Las operaciones de creación, modificación y eliminación utilizan la cabecera X-Usuario.
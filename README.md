# JobFlow

API REST para gestionar y hacer seguimiento de candidaturas de empleo.

## Tecnologías

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Bean Validation
- JUnit
- Mockito
- Maven
- OpenAPI / Swagger
- Git
- Spring Security

## Funcionalidades

- Crear candidaturas
- Consultar todas las candidaturas
- Consultar candidatura por ID
- Actualizar candidaturas
- Eliminar candidaturas
- Validación de datos
- Gestión centralizada de errores
- Persistencia en MySQL
- DTOs de entrada y salida
- Tests automatizados
- Autenticación mediante HTTP Basic
- Autorización por roles
- Endpoints de escritura protegidos para usuarios ADMIN

## Endpoints

| Método | Endpoint | Acción |
|---|---|---|
| GET | `/api/applications` | Listar candidaturas |
| GET | `/api/applications/{id}` | Buscar candidatura |
| POST | `/api/applications` | Crear candidatura |
| PUT | `/api/applications/{id}` | Actualizar candidatura |
| DELETE | `/api/applications/{id}` | Eliminar candidatura |

## Ejecutar el proyecto

La aplicación necesita una base de datos MySQL `jobflow`.

La contraseña se configura mediante la variable de entorno: `DB_PASSWORD`

## Tests

```bash
./mvnw test

## Documentación de la API

Con la aplicación ejecutándose, la documentación interactiva está disponible en:

`http://localhost:8080/swagger-ui.html`

La especificación OpenAPI está disponible en:

`http://localhost:8080/v3/api-docs`
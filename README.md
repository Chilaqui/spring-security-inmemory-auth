# Sistema de Autenticación y Autorización con Spring Security

Este proyecto implementa un sistema de autenticación y autorización basado en roles utilizando Spring Security con usuarios en memoria.

## 📋 Descripción

El sistema proporciona diferentes niveles de acceso a través de endpoints REST protegidos, utilizando autenticación basada en formularios y autorización por roles.

## 🏗️ Arquitectura

### Componentes Principales

- **LogginController**: Controlador REST que maneja los endpoints protegidos
- **SecurityConfig**: Configuración de seguridad de Spring que define usuarios y roles

## 👥 Usuarios Predefinidos

El sistema incluye tres usuarios con diferentes niveles de acceso:

| Usuario    | Contraseña | Roles                      |
|------------|------------|----------------------------|
| `user`     | `2080`     | USER                      |
| `admin`    | `4080`     | ADMIN, USER, DEVELOPER    |
| `developer`| `6080`     | DEVELOPER                 |

## 🔐 Endpoints y Permisos

### Rutas Disponibles

| Endpoint         | Método | Autorización Requerida    | Descripción                    |
|------------------|--------|---------------------------|--------------------------------|
| `/auth/public`   | GET    | USER                      | Página pública para usuarios  |
| `/auth/private`  | GET    | DEVELOPER o ADMIN         | Página privada para desarrolladores |
| `/auth/api`      | GET    | ADMIN                     | Endpoint administrativo        |
| `/auth/actuator` | GET    | USER                      | Información del actuator       |
| `/auth/home`     | GET    | Cualquier usuario autenticado | Página de inicio general    |

## 🚀 Configuración y Uso

### Requisitos Previos

- Java 11 o superior
- Spring Boot
- Spring Security

### Instalación

1. Clona el repositorio
2. Ejecuta la aplicación Spring Boot
3. Accede a `http://localhost:8080`

## 🐳 Docker

Este proyecto incluye un `Dockerfile` para facilitar la creación y despliegue del servicio sin necesidad de instalar Java o Maven localmente.

### 📦 Build de la imagen
```bash
docker build -t memory-app .
```

### 🚀 Ejecución del contenedor
```bash
docker run -p 8080:8080 memory-app
```

La aplicación estará disponible en: http://localhost:8080

### Autenticación

1. Al acceder a cualquier endpoint protegido, serás redirigido al formulario de login
2. Utiliza las credenciales de cualquiera de los usuarios predefinidos
3. Una vez autenticado, podrás acceder a los endpoints según tus permisos

## 📚 Ejemplos de Uso

### Acceso como Usuario Regular
```
Usuario: user
Contraseña: 2080
Endpoints accesibles:
- /auth/public
- /auth/actuator  
- /auth/home
```

### Acceso como Administrador
```
Usuario: admin
Contraseña: 4080
Endpoints accesibles:
- Todos los endpoints (tiene todos los roles)
```

### Acceso como Desarrollador
```
Usuario: developer
Contraseña: 6080
Endpoints accesibles:
- /auth/private
- /auth/home
```

## 🔧 Configuración de Seguridad

### Características Implementadas

- **Autenticación en Memoria**: Los usuarios están definidos directamente en el código
- **Autorización por Roles**: Cada endpoint requiere roles específicos
- **Formulario de Login**: Interfaz web para autenticación
- **Seguridad a Nivel de Método**: Uso de `@PreAuthorize` para control granular

### Anotaciones de Seguridad Utilizadas

- `@PreAuthorize("hasAuthority('ROLE')")`: Requiere un rol específico
- `@PreAuthorize("hasAnyAuthority('ROLE1','ROLE2')")`: Requiere cualquiera de los roles especificados
- `@PreAuthorize("isAuthenticated()")`: Requiere que el usuario esté autenticado

## 🛠️ Personalización

### Agregar Nuevos Usuarios

Para agregar nuevos usuarios, modifica el método `users()` en `SecurityConfig`:

```java
UserDetails nuevoUsuario = users
    .username("nuevouser")
    .password("password")
    .authorities("ROLE_NUEVO")
    .build();
```

### Agregar Nuevos Endpoints

1. Crea nuevos métodos en `LogginController`
2. Aplica las anotaciones `@PreAuthorize` apropiadas
3. Define la lógica del endpoint

## 📝 Notas Importantes

- Los passwords están codificados usando el encoder por defecto de Spring Security
- La configuración CSRF y HTTP Basic están comentadas en el código
- El sistema utiliza formulario de login por defecto
- Los usuarios se almacenan en memoria (no persistentes)

## 🔍 Posibles Mejoras

- Implementar persistencia de usuarios en base de datos
- Agregar funcionalidad de registro de usuarios
- Implementar JWT para APIs REST
- Agregar logs de auditoría de acceso
- Implementar recuperación de contraseñas

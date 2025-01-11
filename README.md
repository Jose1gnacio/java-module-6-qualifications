# Proyecto de Calificaciones (Módulo 6)

Este proyecto es una **mini app** construida con **Spring Boot** (versión 3.x, usando Jakarta) que ofrece:
- Un **Backend** REST para manejar Alumnos, Materias (Hito 1).
- Un **Frontend** con Thymeleaf y un login controlado por Spring Security (Hito 2).

## Características principales

1. **Control de Alumnos**:  
   - Clase `Alumno` con atributos `id`, `rut`, `nombre`, `direccion` y una lista de `Materia`.  
   - Endpoints REST para **crear** (POST) y **listar** (GET).  

2. **Control de Materias**:  
   - Clase `Materia` con atributos `id`, `nombre` y referencia a `Alumno`.  
   - Endpoint REST para **crear** (POST).  

3. **Login y Seguridad**:
   - Se configura **Spring Security** para manejar el formulario de login en la ruta `/login`.
   - Usuario en memoria: `admin / admin`.
   - Redirección a `/home` después de hacer login.  

4. **Frontend con Thymeleaf**:
   - Plantillas `login.html` y `home.html`.
   - `home.html` muestra la lista de Alumnos y sus Materias.

## Requisitos

- **Java 17** (o superior).
- **Maven 3.8+** (o Gradle, según tu configuración).
- **IDE** de preferencia (Eclipse, IntelliJ, VS Code, etc.).

## Cómo ejecutar

1. **Clona** el repositorio o descárgalo en tu máquina local:
   ```bash
   git clone https://github.com/Jose1gnacio/java-module-6-qualifications.git

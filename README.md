# 🏥 Sistema de Agendamiento de Citas Médicas

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> Proyecto académico desarrollado como parte del programa de **Tecnología en Análisis y Desarrollo de Software (ADSO)** del SENA.

---

## 📋 Tabla de Contenidos

- [Acerca del Proyecto](#-acerca-del-proyecto)
- [Estructura del Repositorio](#-estructura-del-repositorio)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Características Principales](#-características-principales)
- [Roles de Usuario](#-roles-de-usuario)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Uso](#-uso)
- [Roadmap](#-roadmap)
- [Contribución](#-contribución)
- [Autor](#-autor)
- [Licencia](#-licencia)

---

## 🎯 Acerca del Proyecto

Este repositorio contiene una serie de proyectos desarrollados en Java que demuestran la evolución y progresión técnica en tecnologías backend, desde fundamentos JDBC hasta arquitecturas empresariales con Spring Boot.

### Contexto

**Evidencias ADSO** es un repositorio académico que implementa un **subconjunto funcional** del Sistema de Agendamiento de Citas Médicas de la IPS Medical Integral. El objetivo principal es demostrar competencias técnicas mediante la implementación del CRUD de la entidad `Paciente` utilizando diferentes arquitecturas Java.

> **Nota Importante:** Este repositorio no representa el proyecto funcional completo. El sistema completo fue desarrollado en Python con Django y se encuentra en el repositorio [`sistema-agendamiento-citas`](https://github.com/kevinagredojara/sistema-agendamiento-citas).

### Objetivo General

Modernizar y optimizar la gestión de citas médicas en la IPS Medical Integral, reemplazando el sistema manual basado en hojas de cálculo por una solución de software centralizada que mejore:

- ✅ Eficiencia operativa
- ✅ Organización de datos
- ✅ Trazabilidad de información
- ✅ Experiencia del usuario

---

## 📁 Estructura del Repositorio

```
Evidencias_ADSO/
│
├── AA2_EV01_JDBC/              # Evidencia 1: Implementación con JDBC
│   └── EvidenciaJdbc/
│       ├── src/
│       │   ├── App.java
│       │   ├── ConexionDB.java
│       │   └── PacienteDAO.java
│       └── lib/
│
├── AA2_EV02_Servlets/          # Evidencia 2: Implementación con Servlets
│   └── agendamientoweb/
│       ├── src/main/
│       │   ├── java/com/kevinagredo/
│       │   │   ├── ConexionDB.java
│       │   │   ├── Paciente.java
│       │   │   ├── PacienteDAO.java
│       │   │   └── PacienteServlet.java
│       │   └── webapp/
│       │       ├── gestionPacientes.jsp
│       │       └── index.jsp
│       └── pom.xml
│
├── AA3_EV01_Spring/            # Evidencia 3: Implementación con Spring Boot
│   └── agendamiento-spring/
│       ├── src/main/
│       │   ├── java/com/kevinagredo/agendamiento_spring/
│       │   │   ├── AgendamientoSpringApplication.java
│       │   │   ├── Paciente.java
│       │   │   ├── PacienteController.java
│       │   │   ├── PacienteRepository.java
│       │   │   └── ServletInitializer.java
│       │   └── resources/
│       │       ├── application.properties
│       │       └── templates/
│       └── pom.xml
│
└── README.md
```

---

## 🛠️ Tecnologías Utilizadas

### Backend

| Tecnología | Versión | Descripción |
|------------|---------|-------------|
| **Java** | 21 | Lenguaje de programación principal |
| **Spring Boot** | 3.5.0 | Framework para desarrollo de aplicaciones |
| **Spring Data JPA** | 3.5.0 | Capa de persistencia |
| **Hibernate** | 6.6.15 | ORM (Object-Relational Mapping) |
| **MySQL Connector** | 8.0+ | Driver de conexión a MySQL |
| **Maven** | 3.9.x | Gestión de dependencias |
| **Thymeleaf** | 3.x | Motor de plantillas |

### Base de Datos

- **MySQL 8.0+** - Sistema de gestión de base de datos relacional

### Frontend (Próxima Implementación)

- **React 18+** - Biblioteca para construcción de interfaces
- **Axios** - Cliente HTTP para consumo de API REST

---

## ⚡ Características Principales

### Implementaciones por Evidencia

#### 📌 AA2_EV01_JDBC
- Conexión directa a base de datos mediante JDBC
- Patrón DAO (Data Access Object)
- Operaciones CRUD básicas para entidad Paciente
- Gestión manual de transacciones

#### 📌 AA2_EV02_Servlets
- Arquitectura MVC con Java Servlets
- Páginas JSP para interfaz de usuario
- Separación de capas (Controlador, Modelo, Vista)
- Gestión de formularios web

#### 📌 AA3_EV01_Spring
- **Arquitectura RESTful** con Spring Boot
- **Spring Data JPA** para abstracción de persistencia
- **Inyección de dependencias** mediante Spring IoC
- **API REST** para operaciones CRUD
- **Thymeleaf** para renderizado de vistas
- **Validación de datos** con Bean Validation
- **Manejo de excepciones** centralizado

### Funcionalidades CRUD Implementadas

| Operación | Endpoint | Método HTTP | Descripción |
|-----------|----------|-------------|-------------|
| **Create** | `/pacientes` | POST | Crear nuevo paciente |
| **Read All** | `/pacientes` | GET | Listar todos los pacientes |
| **Read One** | `/pacientes/{id}` | GET | Obtener paciente por ID |
| **Update** | `/pacientes/{id}` | PUT | Actualizar datos de paciente |
| **Delete** | `/pacientes/{id}` | DELETE | Eliminar paciente |

---

## 👥 Roles de Usuario

El sistema completo está diseñado para cuatro roles principales:

### 1. 🔧 Administrador del Sistema
- Gestión de usuarios internos (Asesores y Profesionales)
- Configuración del catálogo de especialidades médicas
- Gestión de plantillas de horarios
- Mantenimiento del sistema

### 2. 📋 Asesor de Servicio
- Registro y actualización de datos de pacientes
- Asignación, modificación y cancelación de citas
- Consulta de disponibilidad de profesionales
- Envío de notificaciones por correo

### 3. 👨‍⚕️ Profesional de la Salud
- Visualización de agenda personal
- Consulta de datos de pacientes asignados
- Registro de asistencia a citas
- Acceso al historial de citas

### 4. 🧑‍🤝‍🧑 Paciente
- Consulta de citas futuras e historial
- Actualización de datos de contacto
- Visualización de perfil personal

> **Nota:** En las evidencias actuales solo se implementa la gestión de la entidad Paciente.

---

## 📋 Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

- ☑️ **Java JDK 21 o superior**
  ```bash
  java -version
  ```

- ☑️ **Maven 3.9.x o superior**
  ```bash
  mvn -version
  ```

- ☑️ **MySQL 8.0 o superior**
  ```bash
  mysql --version
  ```

- ☑️ **Git**
  ```bash
  git --version
  ```

---

## 🚀 Instalación y Configuración

### 1. Clonar el Repositorio

```bash
git clone https://github.com/kevinagredojara/Evidencias_ADSO.git
cd Evidencias_ADSO
```

### 2. Configurar Base de Datos

```sql
-- Crear base de datos
CREATE DATABASE IF NOT EXISTS agendamiento_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Usar la base de datos
USE agendamiento_db;

-- Crear tabla de pacientes
CREATE TABLE pacientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    documento VARCHAR(20) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    direccion VARCHAR(200),
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo BOOLEAN DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
```

### 3. Configurar Proyecto Spring Boot

Navegar al proyecto Spring:

```bash
cd AA3_EV01_Spring/agendamiento-spring
```

Editar `src/main/resources/application.properties`:

```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/agendamiento_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración de JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true

# Puerto del servidor
server.port=8080
```

### 4. Compilar y Ejecutar

#### Opción 1: Usando Maven Wrapper (Recomendado)

```bash
# Compilar el proyecto
./mvnw clean install

# Ejecutar la aplicación
./mvnw spring-boot:run
```

#### Opción 2: Usando Maven instalado

```bash
# Compilar el proyecto
mvn clean install

# Ejecutar la aplicación
mvn spring-boot:run
```

#### Opción 3: Ejecutar JAR/WAR generado

```bash
# Generar el paquete
./mvnw clean package

# Ejecutar el archivo WAR
java -jar target/agendamiento-spring-1.0-SNAPSHOT.war
```

---

## 💻 Uso

### Acceder a la Aplicación

Una vez iniciada la aplicación, accede a:

- **URL Principal:** http://localhost:8080
- **Gestión de Pacientes:** http://localhost:8080/pacientes

### Ejemplos de API REST

#### Crear Paciente (POST)

```bash
curl -X POST http://localhost:8080/pacientes \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan",
    "apellido": "Pérez",
    "documento": "1234567890",
    "telefono": "3001234567",
    "email": "juan.perez@email.com",
    "direccion": "Calle 123 #45-67"
  }'
```

#### Listar Pacientes (GET)

```bash
curl http://localhost:8080/pacientes
```

#### Obtener Paciente por ID (GET)

```bash
curl http://localhost:8080/pacientes/1
```

#### Actualizar Paciente (PUT)

```bash
curl -X PUT http://localhost:8080/pacientes/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Carlos",
    "apellido": "Pérez García",
    "documento": "1234567890",
    "telefono": "3009876543",
    "email": "juancarlos.perez@email.com",
    "direccion": "Carrera 50 #30-20"
  }'
```

#### Eliminar Paciente (DELETE)

```bash
curl -X DELETE http://localhost:8080/pacientes/1
```

---

## 🗺️ Roadmap

### ✅ Completado

- [x] Implementación CRUD con JDBC (AA2_EV01)
- [x] Implementación con Servlets y JSP (AA2_EV02)
- [x] Implementación con Spring Boot (AA3_EV01)
- [x] API REST para gestión de pacientes
- [x] Actualización a Spring Boot 3.5.0

### 🚧 En Progreso

- [ ] Implementación de frontend con React
- [ ] Integración de autenticación y autorización
- [ ] Implementación de pruebas unitarias e integración

### 📅 Planificado

- [ ] CRUD completo para entidades: Citas, Profesionales, Especialidades
- [ ] Sistema de notificaciones por email
- [ ] Dashboard de administración
- [ ] Generación de reportes
- [ ] Dockerización del proyecto
- [ ] Documentación con Swagger/OpenAPI
- [ ] Deploy en cloud (AWS/Azure/GCP)

---
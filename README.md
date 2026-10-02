# 🚌 Sistema Web de Gestión y Compra de Pasajes Interprovinciales - "Los Chaskis"

![Estado](https://img.shields.io/badge/Estado-En_Desarrollo-yellow)
![Universidad](https://img.shields.io/badge/UTP-Ingeniería_de_Sistemas-red)
![Curso](https://img.shields.io/badge/Curso-Marcos_de_Desarrollo_Web-blue)

## 📌 Información General

- **Universidad:** Universidad Tecnológica del Perú (UTP)
- **Facultad:** Facultad de Ingeniería
- **Carrera:** Ingeniería de Sistemas e Informática
- **Curso:** Marcos de Desarrollo Web (100000S157)
- **Docente:** Moreno Cueva, Máximo Alberto
- **Año:** 2026

### 👥 Integrantes

- Aguilar Vila, Angeles Abril
- Auqui Alvarez, Diego Alonso
- Chuquiruna Aguilar, Elsa Elizabeth
- Torres Arevalo, Freddy Joel

---

## 🏬 Descripción del Proyecto

**Los Chaskis** es una aplicación web orientada a la gestión de una empresa de transporte interprovincial de pasajeros.

El sistema integra procesos administrativos, operativos y de atención al cliente, permitiendo gestionar buses, choferes, rutas y viajes, además de representar el flujo de búsqueda y compra de pasajes, el control de embarque y la visualización de reportes.

---

## 🎯 Objetivo General

Desarrollar un sistema web que permita centralizar la gestión de las principales operaciones de la empresa **Los Chaskis**, facilitando la administración de información y el acceso diferenciado para clientes, administradores y supervisores.

---

## 🛠️ Tecnologías

| Capa / Herramienta | Tecnología |
| :--- | :--- |
| **Frontend** | HTML5, CSS3, JavaScript, Bootstrap 5, Thymeleaf |
| **Backend** | Java 21, Spring Boot, Spring Web |
| **Gráficos** | Chart.js |
| **Persistencia prevista** | MySQL, Spring Data JPA, Hibernate |
| **Seguridad prevista** | Spring Security |
| **Dependencias** | Maven |
| **Control de versiones** | Git & GitHub |
| **Despliegue** | Render |

---

## 📋 Funcionalidades Principales

- 🚌 Gestión de buses.
- 👨‍✈️ Gestión de choferes.
- 🗺️ Gestión de rutas y viajes.
- 🎟️ Portal de búsqueda y compra de pasajes.
- 💺 Selección de asientos y registro de pasajeros.
- 👷 Control de embarque y supervisión de terminal.
- 📊 Dashboard y reportes gráficos.
- 🔐 Acceso diferenciado por roles.
- 💳 Gestión de pagos y comprobantes en etapas posteriores.

---

## 🏗️ Arquitectura General

```text
src/main/java/com/loschaskis/sistema_transporte/
├── controller/
├── model/
├── service/
├── repository/
├── security/
└── SistemaTransporteApplication.java

src/main/resources/
├── templates/
├── static/
├── application.properties
├── schema.sql
└── data.sql
```

---

## 🔗 Módulos Principales

| Módulo | Ruta |
| :--- | :--- |
| Portal público | `/` |
| Login | `/login` |
| Dashboard administrativo | `/admin/dashboard` |
| Buses | `/admin/buses` |
| Choferes | `/admin/choferes` |
| Rutas | `/admin/rutas` |
| Viajes | `/admin/viajes` |
| Reportes | `/admin/reportes` |
| Supervisor | `/supervisor/dashboard` |
| Embarque | `/supervisor/embarque` |
| Plano de asientos | `/supervisor/plano-asientos` |

---

## 🚀 Ejecución Local

### Requisitos

- Java 21
- Git

### Windows

```powershell
.\mvnw.cmd spring-boot:run
```

Luego abrir:

```text
http://localhost:8080
```

---

## 🌐 Despliegue

El proyecto está preparado para ser gestionado mediante **GitHub** y desplegado en **Render**, permitiendo publicar nuevas versiones a partir de los cambios realizados en la rama principal del repositorio.

---

## 📚 Contexto Académico

Proyecto desarrollado para el curso **Marcos de Desarrollo Web** de la **Universidad Tecnológica del Perú**.

**Agencia de Transportes "Los Chaskis" S.A.**

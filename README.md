# AI Incident Assistant

A backend-focused Incident Management System built with Spring Boot and PostgreSQL.

This project demonstrates production-style backend development practices including REST APIs, validation, exception handling, pagination, filtering, Docker, and PostgreSQL integration.

---

## Features

- Create new incidents
- Retrieve incidents
- Retrieve incident by ID
- Update incident status
- Filter incidents by status
- Filter incidents by severity
- Pagination support
- Request validation
- Global exception handling
- Swagger/OpenAPI documentation
- PostgreSQL persistence
- Dockerized deployment
- pgAdmin integration

---

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- PostgreSQL 16
- Docker
- Docker Compose
- pgAdmin
- Maven
- Swagger / OpenAPI

---

## Architecture

```
Client
   │
   ▼
Spring Boot REST API
   │
   ▼
Service Layer
   │
   ▼
JPA / Hibernate
   │
   ▼
PostgreSQL
```

---

## Database

Table:

```
incidents
```

Columns

| Column | Type |
|---------|------|
| id | bigint |
| title | varchar |
| description | varchar |
| severity | varchar |
| status | varchar |
| created_at | timestamptz |
| updated_at | timestamptz |

---

## Running the Project

### Clone

```bash
git clone https://github.com/kavya259/ai-incident-assistant.git
cd ai-incident-assistant
```

### Start PostgreSQL & pgAdmin

```bash
docker compose up -d
```

Services

- Spring Boot: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI Docs: http://localhost:8080/v3/api-docs
- PostgreSQL: localhost:5433
- pgAdmin: http://localhost:5050

---

## API Endpoints

| Method | Endpoint |
|---------|----------|
| POST | /api/incidents |
| GET | /api/incidents |
| GET | /api/incidents/{id} |
| PUT | /api/incidents/{id}/status |

---

## Status

Current implementation includes:

- REST APIs
- PostgreSQL integration
- Docker support
- Swagger documentation
- Validation
- Global exception handling
- Pagination
- Filtering
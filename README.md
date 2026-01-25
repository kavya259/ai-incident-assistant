\# AI Incident Assistant



A backend-focused Spring Boot application for tracking and managing system incidents.

Built with production-style practices: REST APIs, PostgreSQL, Docker, and version control.



---



\## Tech Stack

\- Java 17

\- Spring Boot 3.x

\- Spring Data JPA

\- PostgreSQL 16

\- Docker \& Docker Compose

\- pgAdmin (DB UI)



---



\## Architecture (Current)



Client (API calls)

↓

Spring Boot REST API

↓

JPA / Hibernate

↓

PostgreSQL (Docker)









---



\## Current Features

\- Health check endpoint (`/health`)

\- Incident persistence using JPA

\- PostgreSQL running in Docker

\- pgAdmin UI to inspect data

\- Table auto-created via Hibernate

\- GitHub versioned development



---



\## Database Schema

\*\*Table:\*\* `incidents`



| Column | Type |

|------|------|

| id | bigint (PK) |

| title | varchar |

| description | varchar |

| severity | varchar |

| status | varchar |

| created\_at | timestamptz |

| updated\_at | timestamptz |



---



\## Running the Project



\### 1. Start Database \& pgAdmin

```bash

docker compose up -d



PostgreSQL → port 5433



pgAdmin → http://localhost:5050








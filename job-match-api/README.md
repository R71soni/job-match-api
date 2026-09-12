# Job Match API

## Project Overview

Job Match API is a Spring Boot REST API that recommends jobs to candidates
based on skills, experience, location, and salary fit.

The API calculates a transparent match score from 0 to 100 and returns
ranked job recommendations for a candidate.

The recommendation engine is rule-based and deterministic. No machine
learning or collaborative filtering is used, making the scoring logic
easy to understand, test, and explain.

---

## Key Features

- Create a candidate profile
- Retrieve a candidate by ID
- Create a job posting
- Retrieve a job by ID
- Delete a job
- Get ranked job recommendations
- Support top-N recommendations using the `limit` query parameter
- MUST_HAVE skill hard filtering
- NICE_TO_HAVE skill scoring
- Experience-based scoring
- Location-based scoring
- Salary compatibility scoring
- Request validation
- Custom salary range validation
- Global exception handling
- PostgreSQL persistence
- Unit tests for scoring logic

---

## Tech Stack

- Java 25
- Spring Boot 4.1.1
- Spring Web
- Spring Data JPA
- Hibernate
- Jakarta Validation
- PostgreSQL
- Maven
- JUnit 5
- Mockito
- Git / GitHub

---

# Scoring Formula

The recommendation score is calculated out of 100 points.

| Factor | Maximum Score |
|---|---:|
| Skills | 50 |
| Experience | 20 |
| Location | 15 |
| Salary | 15 |
| **Total** | **100** |

The overall score is:

```text
Overall Score =
Skills Score
+ Experience Score
+ Location Score
+ Salary Score
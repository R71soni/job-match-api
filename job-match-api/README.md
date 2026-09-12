# Job Match API

A Spring Boot REST API that recommends jobs to candidates based on:

- Skills
- Experience
- Location
- Expected salary

The API ranks matching jobs using a transparent scoring system from **0 to 100**.

---

## Tech Stack

- Java 21+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- JUnit 5
- Mockito

---

## Features

### Candidate APIs

Create a candidate with:

- Name
- Skills
- Years of experience
- Location
- Expected salary

### Job APIs

Create a job with:

- Job title
- Required skills
- MUST_HAVE / NICE_TO_HAVE skill types
- Minimum experience
- Location
- Remote availability
- Salary range

### Recommendation API

Returns jobs ranked by matching score.

Example:

```text
GET /recommendations/{candidateId}?limit=10
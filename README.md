# Job Match API

A Spring Boot REST API that recommends suitable jobs to candidates based on **skills, experience, location, and expected salary**.

## 🚀 Features

* Create and manage candidates
* Create and manage jobs
* Store candidate skills
* Store required job skills
* Match candidates with suitable jobs
* Calculate job suitability based on:

  * Skills
  * Years of experience
  * Location
  * Expected salary
* PostgreSQL database integration
* RESTful APIs
* Spring Data JPA

## 🛠️ Tech Stack

* **Java 21**
* **Spring Boot 4.1.1**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL**
* **Maven**
* **REST API**
* **Git & GitHub**

## 📁 Project Structure

```text
job-match-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/lernern/jobmatch/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── JobMatchApiApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

## 👤 Candidate Model

A candidate contains:

```text
id
name
skills
yearsOfExperience
location
expectedSalary
```

Example:

```json
{
  "name": "Ritesh",
  "skills": [
    "Java",
    "Spring Boot",
    "Angular"
  ],
  "yearsOfExperience": 1,
  "location": "Delhi",
  "expectedSalary": 500000
}
```

## 💼 Job Model

A job contains:

```text
id
title
requiredSkills
yearsOfExperience
location
salary
```

Required skills can be categorized as:

* Must-have
* Nice-to-have

## 🔗 API Endpoints

### Candidate APIs

#### Create Candidate

```http
POST /candidates
```

Example request:

```json
{
  "name": "Ritesh",
  "skills": [
    "Java",
    "Spring Boot",
    "Angular"
  ],
  "yearsOfExperience": 1,
  "location": "Delhi",
  "expectedSalary": 500000
}
```

#### Get Candidate

```http
GET /candidates/{id}
```

#### Get All Candidates

```http
GET /candidates
```

## Job APIs

#### Create Job

```http
POST /jobs
```

#### Get All Jobs

```http
GET /jobs
```

#### Get Job

```http
GET /jobs/{id}
```

## 🎯 Job Matching

The matching API recommends jobs for a candidate based on multiple factors:

```text
Candidate
   │
   ├── Skills
   ├── Experience
   ├── Location
   └── Expected Salary
          │
          ▼
   Matching Algorithm
          │
          ▼
   Recommended Jobs
```

Example:

```http
GET /candidates/{id}/matches
```

The API returns suitable jobs ranked according to the candidate's compatibility.

## 🗄️ Database

This project uses **PostgreSQL**.

Database configuration is maintained in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/job_match_db
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Replace `YOUR_PASSWORD` with your local PostgreSQL password. Do not commit real database passwords or secrets to GitHub.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/R71soni/job-match-api.git
```

### 2. Open the project

```bash
cd job-match-api
```

### 3. Configure PostgreSQL

Create a database:

```sql
CREATE DATABASE job_match_db;
```

Update your database credentials in:

```text
application.properties
```

### 4. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## 🧪 Testing

You can test the APIs using:

* Postman
* Insomnia
* cURL
* IntelliJ HTTP Client

Example:

```bash
curl -X POST http://localhost:8080/candidates ^
  -H "Content-Type: application/json" ^
  -d "{\"name\":\"Ritesh\",\"skills\":[\"Java\",\"Spring Boot\"],\"yearsOfExperience\":1,\"location\":\"Delhi\",\"expectedSalary\":500000}"
```

## 📌 Future Improvements

* JWT authentication
* Candidate login and registration
* Job search and filtering
* Advanced job matching score
* Pagination and sorting
* Global exception handling
* Input validation
* Swagger/OpenAPI documentation
* Docker support
* Unit and integration testing
* Deployment to cloud

## 👨‍💻 Author

**Ritesh Kumar**

GitHub: [R71soni](https://github.com/R71soni)

---

⭐ If you find this project useful, consider giving it a star!

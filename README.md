## Spring Boot Job Application API

A Spring Boot REST API for managing Companies, Jobs, and Reviews, backed by PostgreSQL and fully Dockerized using docker-compose.

This project demonstrates:
- RESTful API design
- Spring Boot + Spring Data JPA
- Entity relationships (One-to-Many, Many-to-One)
- PostgreSQL integration
- Docker & Docker Compose setup
- Clean layered architecture (Controller → Service → Repository)

### 🏗️ Project Structure
```
SpringBootJobApplicationApp
├── src
│   ├── main
│   │   ├── java/com/springboot/jobapp
│   │   │   ├── company
│   │   │   │   ├── impl
│   │   │   │   │   └── CompanyServiceImpl.java
│   │   │   │   ├── Company.java
│   │   │   │   ├── CompanyController.java
│   │   │   │   ├── CompanyRepository.java
│   │   │   │   └── CompanyService.java
│   │   │   ├── job
│   │   │   │   ├── impl
│   │   │   │   │   └── JobServiceImpl.java
│   │   │   │   ├── Job.java
│   │   │   │   ├── JobController.java
│   │   │   │   ├── JobRepository.java
│   │   │   │   └── JobService.java
│   │   │   ├── review
│   │   │   │   ├── impl
│   │   │   │   │   └── ReviewServiceImpl.java
│   │   │   │   ├── Review.java
│   │   │   │   ├── ReviewController.java
│   │   │   │   ├── ReviewRepository.java
│   │   │   │   └── ReviewService.java
│   │   │   └── JobappApplication.java
│   │   └── resources
│   │       └── application.properties
├── docker-compose.yaml
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

### 🧠 Domain Model

#### Company
One Company can have:
- Many Jobs
- Many Reviews

#### Job
Each Job belongs to one Company

#### Review
Each Review belongs to one Company

Entity relationships are managed using JPA annotations.

### ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Hibernate
- Docker & Docker Compose
- Maven

### 🚀 Running the Application (Docker)

#### 1️⃣ Prerequisites
Make sure you have:
- Docker
- Docker Compose

#### 2️⃣ Environment Variables
Create a `.env` file in the project root:
```env
POSTGRES_USER=Your Username
POSTGRES_PASSWORD=Your password
POSTGRES_DB=your db name

```

#### 3️⃣ Start Containers
```bash
docker-compose up -d
```

This will start:
- PostgreSQL
- pgAdmin
- Spring Boot Job Application

#### 4️⃣ Access Services

| Service | URL |
|---------|-----|
| Spring Boot API | http://localhost:8080 |
| pgAdmin | http://localhost:5050 |
| PostgreSQL | localhost:5432 |

### 🛠️ API Endpoints

#### 🏢 Company APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/companies` | Get all companies |
| GET | `/companies/{id}` | Get company by ID |
| POST | `/companies` | Create a company |
| PUT | `/companies/{id}` | Update a company |
| DELETE | `/companies/{id}` | Delete a company |

**Create Company**
```http
POST /companies
```
```json
{
  "name": "Google",
  "description": "Tech Company"
}
```

#### 💼 Job APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/jobs` | Get all jobs |
| GET | `/jobs/{id}` | Get job by ID |
| POST | `/jobs` | Create a job |
| PUT | `/jobs/{id}` | Update a job |
| DELETE | `/jobs/{id}` | Delete a job |

**Create Job**
```http
POST /jobs
```
```json
{
  "title": "Backend Developer",
  "description": "Spring Boot Developer",
  "minSalary": "80000",
  "maxSalary": "120000",
  "location": "Remote"
}
```

#### ⭐ Review APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/companies/{companyId}/reviews` | Get all reviews |
| GET | `/companies/{companyId}/reviews/{reviewId}` | Get review |
| POST | `/companies/{companyId}/reviews` | Add review |
| PUT | `/companies/{companyId}/reviews/{reviewId}` | Update review |
| DELETE | `/companies/{companyId}/reviews/{reviewId}` | Delete review |

**Add Review**
```http
POST /companies/1/reviews
```
```json
{
  "title": "Great Place",
  "description": "Amazing work culture",
  "rating": 4.5
}
```

### 🧩 Architecture
```
Controller
    ↓
Service
    ↓
Repository
    ↓
Database (PostgreSQL)
```

- **Controller** → Handles HTTP requests
- **Service** → Business logic
- **Repository** → Database access
- **Entity** → JPA mapped objects

### 🐳 Docker Services

#### PostgreSQL
- Image: `postgres:latest`
- Port: `5432`

#### pgAdmin
- Image: `dpage/pgadmin4`
- Port: `5050`

#### Spring Boot App
- Image: `saylee06/jobappimage:latest`
- Port: `8080`

### 📌 Notes

- `spring.jpa.hibernate.ddl-auto=update` automatically updates DB schema
- Circular references avoided using `@JsonIgnore`
- Constructor-based dependency injection is used
- REST API follows standard HTTP status codes


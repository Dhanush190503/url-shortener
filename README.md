# URL Shortener API

A backend URL Shortener application built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL.

The application allows users to create short URLs, redirect to original URLs, track click counts, view URL statistics, and delete URLs through RESTful APIs.

---

## Features

* Create short URLs
* Redirect short URLs to original URLs
* Track click counts
* View URL statistics
* Delete URLs
* Request validation
* Global exception handling
* Custom exceptions
* MySQL database integration
* Swagger/OpenAPI documentation
* Unit testing with JUnit and Mockito

---

## Tech Stack

* Java 17
* Spring Boot 4
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* JUnit 5
* Mockito
* Swagger/OpenAPI

---

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.danuz.url_shortener
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       ├── service
│   │       └── util
│   └── resources
└── test
    └── java
```

## API Endpoints

### Create Short URL

```http
POST /api/v1/urls
```

Request:

```json
{
  "originalUrl": "https://www.google.com"
}
```

---

### Redirect URL

```http
GET /{shortCode}
```

Example:

```http
GET /5
```

---

### Get URL Statistics

```http
GET /api/v1/urls/stats/{shortCode}
```

Example:

```http
GET /api/v1/urls/stats/5
```

---

### Delete URL

```http
DELETE /api/v1/urls/{shortCode}
```

Example:

```http
DELETE /api/v1/urls/5
```

---

## Database

Database: MySQL

Table:

```sql
urls
```

Columns:

* id
* original_url
* short_code
* click_count
* created_at

---

## Swagger Documentation

After running the application:

```text
http://localhost:8081/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:8081/v3/api-docs
```

---

## Running the Project

Clone the repository:

```bash
git clone <repository-url>
```

Navigate to the project:

```bash
cd url-shortener
```

Run the application:

```bash
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8081
```

---

## Testing

Run all tests:

```bash
mvn test
```

Current test coverage includes:

* Service layer tests
* Spring Boot application context tests

---

## Future Improvements

* Docker support
* User authentication
* Custom aliases for short URLs
* URL expiration
* Rate limiting
* Cloud deployment
* Analytics dashboard

```
```

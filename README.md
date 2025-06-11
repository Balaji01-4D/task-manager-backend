
# 🧩 Task Manager Backend

This is the **Spring Boot backend API** for the [Task Manager App](https://github.com/Balaji01-4D/task-manager-frontend), a full-stack task management system with CRUD operations, filtering, and search capabilities.

The backend handles business logic, data persistence, and provides RESTful APIs to the React + Vite frontend.

---

## 🔗 Frontend Repository

👉 [View Task Manager Frontend](https://github.com/Balaji01-4D/task-manager-frontend)

---

## 📦 Tech Stack

- **Java 21**
- **Spring Boot 3+**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL** (configurable)
- **Maven**
- **Lombok**

---

## 🧱 Task Entity Model

```java
public class Task {
    private int id;
    private String title;
    private String description;
    private Date createdDate;
    private boolean completed;
    private int priority; // 1 to 10
}
````

## 🚀 API Endpoints

| Method | Endpoint            | Description                                      |
| ------ | ------------------- | ------------------------------------------------ |
| GET    | `/api/tasks`        | Get all tasks                                    |
| GET    | `/api/tasks/{id}`   | Get task by ID                                   |
| POST   | `/api/tasks`        | Create a new task                                |
| PUT    | `/api/tasks/{id}`   | Update task by ID                                |
| DELETE | `/api/tasks/{id}`   | Delete task by ID                                |
| GET    | `/api/tasks/search` | Search/filter tasks (by title, priority, status) |

---

## ⚙️ Getting Started

### 1. Clone the Repo

```bash
git clone https://github.com/Balaji01-4D/task-manager-backend.git
cd task-manager-backend
```

### 2. Build & Run (Spring Boot)

You can run the project using your IDE or the terminal:

```bash
./mvnw spring-boot:run
```

### 3. Access the App

* API Base URL: `http://localhost:8080/api/tasks`
* H2 Console (for testing DB): `http://localhost:8080/h2-console`

---

## 🌱 Environment Configuration

You can customize the database and port in `src/main/resources/application.properties`.

Example for H2:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tasks
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.username=username
spring.datasource.password=user password

# JPA & Hibernate Config
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

```

---

## 🙋 Author

* [Balaji](https://github.com/Balaji01-4D)

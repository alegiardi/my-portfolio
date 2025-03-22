# My Portfolio

My personal website built with Java Spring Boot for the backend and React for the frontend.

## Technologies Used

- Backend:

  - Java 17
  - Spring Boot 3.2.3
  - Spring Data JPA
  - H2 Database (for development)
  - Maven
  - Lombok

- Frontend (planned):
  - React
  - (Additional frontend technologies will be added as development progresses)

## Project Structure

```bash
my-portfolio/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── portfolio/
│   │   └── resources/
│   └── test/
└── pom.xml
```

## Getting Started

1. Ensure you have Java 17 installed
2. Clone the repository
3. Run `mvn clean install` to build the project
4. Run `mvn spring-boot:run` to start the application
5. Access the application at `http://localhost:8080`

## Development

- The H2 console is available at `http://localhost:8080/h2-console`
- Default database credentials are in `application.properties`

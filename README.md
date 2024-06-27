# Unit Test Demo Project

This project is a simple demonstration of unit testing in a Spring Boot application. It includes basic CRUD operations for managing `Student` entities, with corresponding unit tests for the service layer.

## Project Structure

- **controller**: Contains the `StudentController` class which handles HTTP requests.
- **entity**: Contains the `Student` class which represents the student entity.
- **repository**: Contains the `StudentRepository` interface which interacts with the database.
- **service**: Contains the `StudentService` class which contains the business logic.
- **service/test**: Contains the `StudentServiceTest` class which includes unit tests for the `StudentService`.

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6.3 or later
- An IDE of your choice (IntelliJ IDEA, Eclipse, etc.)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/UnitTestDemoProject.git
   cd UnitTestDemoProject


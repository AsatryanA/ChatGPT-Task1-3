# Social Media Application

This is a simple social media application built with Spring Boot, Hibernate, and PostgreSQL. The application allows users to create and view posts, follow other users, and like posts.

## Table of Contents
- [Technologies](#technologies)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Setup](#setup)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Technologies
- Spring Boot
- Hibernate
- PostgreSQL
- Spring Data JPA
- Spring Web

## Getting Started

### Prerequisites
- Java 8 or later
- Maven
- PostgreSQL

### Setup
1. Clone the repository:

   ```bash
   git clone  https://github.com/AsatryanA/ChatGPT-Task1-3.git
    ```
2. Configure PostgreSQL:
   - Create a database named `social_media_app`
   - Create a user with the username `postgres` and password `postgres`
   - Grant all privileges on the `social_media_app` database to the `postgres` user
3. 
4. Run the application:
   ```bash
   mvn spring-boot:run
   
## API Endpoints

### User
- Follow User:
    - POST /api/users/{userId}/follow/{followerId}
- Additional user-related endpoints can be added based on your requirements.

### Post

- Like Post:
    - POST /api/posts/{postId}/like/{userId}
- Additional post-related endpoints can be added based on your requirements.

## Testing
The application includes unit tests for controllers, services, and repositories. You can run the tests using:
```bash
mvn test
```
## Contributing

Contributions are welcome! If you find a bug or have a feature request, please open an issue or submit a pull request.

## License

This project is licensed under the terms of the [MIT](https://choosealicense.com/licenses/mit/) license.
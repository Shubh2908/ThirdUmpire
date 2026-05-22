# Third Umpire

Third Umpire is a backend project built using Spring Boot microservices for managing cricket matches and related operations.  
The project is divided into multiple services, where each service handles a specific responsibility such as authentication, match management, player management, and score tracking.

## Services Included

- **api-gateway** → Central entry point for routing client requests
- **auth-service** → User authentication and JWT-based authorization
- **eureka-server** → Service registry for service discovery
- **match-service** → Handles match-related operations
- **player-service** → Manages player details and statistics
- **score-service** → Handles score updates and live match scoring

## Tech Used

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Cloud Gateway
- Eureka Server
- PostgreSQL
- Docker
- Kafka
- REST APIs

## Features

- User authentication and authorization
- API Gateway for request routing
- Service discovery with Eureka
- Match and player management
- Score management
- Dockerized setup for running services
- Event-driven communication using Kafka

## Project Structure

```text
ThirdUmpire
├── api-gateway
├── auth-service
├── eureka-server
├── match-service
├── player-service
├── score-service
└── docker-compose.yml
```

## Running the Project

Clone the repository:

```bash
git clone https://github.com/Shubh2908/ThirdUmpire.git
```

Run the services:

```bash
docker-compose up
```

## Note

This project was built as a learning project to understand how backend systems can be designed using microservices architecture with Spring Boot.

## Author

Shubham Kasera

# spring-security-jpa-demo

This is a demo project that shows how to authenticate against the database by using Spring Data JPA.
The project uses a postgres db with liquibase. Redis is used for managing sessions

## Build
```
.\mvnw -DskipTests clean install
```

## Run services
```
docker compose up -d
```

## Redis commander
Navigate to:
```
http://localhost:8081
```

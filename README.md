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

## Login
Upon visiting a protected resource:
```
http://localhost:8080/api/v1/auth/profile
```
You will be redirected to spring security form login where you can authenticate.
Liquibase will insert 2 users.

```
role: ROLE_ADMIN
username: admin@demo.hr
password: admin
------------------------
role: ROLE_USER
username: user@demo.hr
password: user
```

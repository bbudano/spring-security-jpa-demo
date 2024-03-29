FROM openjdk:17-oracle
COPY ./target/spring-security-jpa-demo-*.jar service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service.jar"]

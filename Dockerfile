FROM openjdk:11-oraclelinux8
COPY ./build/libs/spring-security-jpa-demo-*.jar service.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/service.jar"]

FROM java:8
FROM maven:alpine

WORKDIR /app
COPY . /app
RUN mvn package

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/target/BFF-0.0.1-SNAPSHOT.jar"]
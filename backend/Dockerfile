FROM openjdk:17-jdk-slim

WORKDIR /backend

COPY pom.xml /backend/
COPY src /backend/src
COPY mvnw /backend/mvnw
COPY mvnw.cmd /backend/mvnw.cmd
COPY .mvn /backend/.mvn

RUN chmod +x /backend/mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "/backend/target/demo-0.0.1-SNAPSHOT.jar"]

ENV SPRING_PROFILES_ACTIVE=prod

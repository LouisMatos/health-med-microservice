FROM openjdk:21-jdk-slim as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Ensure the mvnw script has the correct permissions and line endings
RUN chmod +x mvnw
RUN sed -i 's/\r$//' mvnw

# Run the mvnw script with the correct path
RUN ./mvnw package -DskipTests dependency:resolve

WORKDIR /app/target

ENTRYPOINT ["java", "-jar", "health-med-microservice-0.0.1-SNAPSHOT.jar"]

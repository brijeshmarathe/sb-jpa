# Dockerfile for building a Java application
FROM maven:3.8.4-openjdk-21 AS build
RUN mvn clean install -DskipTests

FROM openjdk:21
#RUN mvn clean install -DskipTests
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} jpaapp.jar
ENTRYPOINT ["java","-jar","/jpaapp.jar"]
EXPOSE 8080
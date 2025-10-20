# STAGE 1 - BUILD
FROM openjdk:21-jdk AS builder
RUN microdnf install findutils

WORKDIR /app

COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle
COPY src /app/src

RUN chmod +x gradlew
RUN ./gradlew clean bootJar

#STAGE 2 - RUN
FROM alpine/java:21-jre

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

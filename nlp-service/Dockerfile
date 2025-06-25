
FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/nlpservice-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8093

ENTRYPOINT ["java", "-jar", "/app.jar"]

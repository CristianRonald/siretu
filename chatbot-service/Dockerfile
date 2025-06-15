# Etapa de construcción con Maven
FROM maven:3.8.6-eclipse-temurin-17 as builder

WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=builder /build/target/chatbot-service-*.jar app.jar
ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseG1GC -XX:MaxRAMPercentage=75"

RUN addgroup --system spring && adduser --system --ingroup spring spring
USER spring:spring
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar app.jar"]

EXPOSE 8080

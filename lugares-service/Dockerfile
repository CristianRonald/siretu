FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copiar el JAR directamente
COPY target/lugares-0.0.1-SNAPSHOT.jar app.jar

# Copiar configuración explícitamente (¡clave!)
COPY src/main/resources/application.yml ./config/application.yml

EXPOSE 8092

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=classpath:/,file:./config/"]

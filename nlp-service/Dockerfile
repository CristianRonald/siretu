
FROM eclipse-temurin:17

ARG JAR_FILE=target/nlpservice-0.0.1-SNAPSHOT.jar

RUN apt-get update && \
    apt-get install -y python3 python3-pip python3-venv && \
    python3 -m venv /opt/venv && \
    /opt/venv/bin/pip install --no-cache-dir sentence-transformers && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV PATH="/opt/venv/bin:$PATH"

WORKDIR /app
COPY src/main/resources/application.yml ./config/application.yml
COPY target/nlpservice-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8093

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=classpath:/,file:./config/"]

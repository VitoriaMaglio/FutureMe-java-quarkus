FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o jar gerado pelo Quarkus
COPY target/*-runner.jar app.jar

EXPOSE 8080

ENV PORT=8080

CMD ["java", "-jar", "app.jar"]

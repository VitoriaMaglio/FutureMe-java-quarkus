# ===========================
# 1° Stage: Build (Maven)
# ===========================
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /build

# Copia o pom.xml e baixa dependências (cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia todo o projeto
COPY . .

# Builda sem rodar testes
RUN mvn package -DskipTests -Dquarkus.package.type=uber-jar

# ===========================
# 2° Stage: Runtime
# ===========================
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copia o jar do estágio anterior
COPY --from=build /build/target/*-runner.jar app.jar

EXPOSE 8080

# Sobe o app
CMD ["java", "-jar", "app.jar"]


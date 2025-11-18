# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: Imagem final (mais leve)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Render usa PORT dinâmica! Use isso:
ENV PORT=8080

CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]

# Etapa 1: Compilar y empaquetar el JAR con Maven y Java 25
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw && ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw package -DskipTests

# Etapa 2: Imagen final ligera con JRE 25 para ejecutar la app
FROM eclipse-temurin:25-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
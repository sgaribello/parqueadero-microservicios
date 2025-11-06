# ---- build ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copia desde el root del repo
COPY players-service/pom.xml ./players-service/pom.xml
RUN mvn -q -f players-service/pom.xml -DskipTests dependency:go-offline
COPY players-service/src ./players-service/src
RUN mvn -q -f players-service/pom.xml -DskipTests clean package

# ---- run ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/players-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

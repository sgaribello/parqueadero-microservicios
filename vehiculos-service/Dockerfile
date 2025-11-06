# ---- build ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copia desde el root del repo
COPY vehiculos-service/pom.xml ./vehiculos-service/pom.xml
RUN mvn -q -f vehiculos-service/pom.xml -DskipTests dependency:go-offline
COPY vehiculos-service/src ./vehiculos-service/src
RUN mvn -q -f vehiculos-service/pom.xml -DskipTests clean package

# ---- run ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/vehiculos-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

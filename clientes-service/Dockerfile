# ---- build ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
# Copia desde el root del repo
COPY clientes-service/pom.xml ./clientes-service/pom.xml
RUN mvn -q -f clientes-service/pom.xml -DskipTests dependency:go-offline
COPY clientes-service/src ./clientes-service/src
RUN mvn -q -f clientes-service/pom.xml -DskipTests clean package

# ---- run ----
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/clientes-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

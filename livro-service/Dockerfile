# ===============================
# ETAPA 1 - Build da aplicação
# ===============================
FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# ===============================
# ETAPA 2 - Imagem final
# ===============================
FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
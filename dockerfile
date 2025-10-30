# Dockerfile

# Utilise OpenJDK 17 (LTS)
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copie le JAR généré par Maven
COPY target/*.jar app.jar

# Expose le port de Spring Boot
EXPOSE 8080

# Lance l'application
ENTRYPOINT ["java","-jar","app.jar"]

# Dockerfile
# Utilise OpenJDK 21
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copie le JAR généré par Maven
COPY target/*.jar app.jar

# Expose le port de Spring Boot
EXPOSE 8080

# Lance l'application
ENTRYPOINT ["java","-jar","app.jar"]

# Étape 1 : Build de l'application avec Maven + JDK 17
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers Maven
COPY pom.xml .
COPY src ./src

# Compiler le projet et générer le jar
RUN mvn clean package -DskipTests

# Étape 2 : Image finale légère pour exécuter l'application
FROM eclipse-temurin:17-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier le jar depuis l'image build
COPY --from=build /app/target/gestion_projet-1.0.jar app.jar

# Exposer le port de l'application Spring Boot
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

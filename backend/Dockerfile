# Utilise une JDK officielle
FROM eclipse-temurin:21-jdk

# Crée un dossier de travail dans le conteneur
WORKDIR /app

# Copie le JAR dans le conteneur
COPY target/*.jar app.jar

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

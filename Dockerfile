# Base image (Java runtime)
FROM eclipse-temurin:17-jdk

# Working directory
WORKDIR /app

# JAR file copy karo
COPY target/myapp.jar app.jar

# Port expose (optional but good practice)
# EXPOSE 8080

# App run karo
ENTRYPOINT ["java", "-jar", "app.jar"]
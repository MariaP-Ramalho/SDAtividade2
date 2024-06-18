FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/perfil-app.jar
EXPOSE 8181
CMD ["java", "-jar", "perfil-app.jar"]
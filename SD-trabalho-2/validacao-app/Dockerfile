FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/validacao-app.jar
EXPOSE 8182
CMD ["java", "-jar", "validacao-app.jar"]
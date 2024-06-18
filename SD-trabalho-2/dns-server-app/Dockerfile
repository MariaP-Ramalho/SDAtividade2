FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/dns-server-app.jar
EXPOSE 8081
CMD ["java", "-jar", "dns-server-app.jar"]
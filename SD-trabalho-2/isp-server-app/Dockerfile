FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/isp-server-app.jar
EXPOSE 8080
CMD ["java", "-jar", "isp-server-app.jar"]
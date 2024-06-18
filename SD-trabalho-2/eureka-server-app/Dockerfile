FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/eureka-server-app.jar
EXPOSE 8761
CMD ["java", "-jar", "eureka-server-app.jar"]
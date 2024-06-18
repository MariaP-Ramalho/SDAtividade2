FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/dfs-a-app.jar
EXPOSE 8184
CMD ["java", "-jar", "dfs-a-app.jar"]
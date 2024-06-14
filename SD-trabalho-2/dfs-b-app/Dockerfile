FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/dfs-b-app.jar
EXPOSE 8185
CMD ["java", "-jar", "dfs-b-app.jar"]
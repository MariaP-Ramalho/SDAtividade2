FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/dfs-master-app.jar
EXPOSE 8183
CMD ["java", "-jar", "dfs-master-app.jar"]
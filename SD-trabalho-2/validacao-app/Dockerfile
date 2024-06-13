FROM openjdk:17-jdk-alpine
RUN apk add --no-cache maven
WORKDIR /app
COPY . /app
EXPOSE 8182
CMD ["mvn", "spring-boot:run"]
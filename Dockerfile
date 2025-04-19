#FROM openjdk:17-jdk-slim
#
## ✅ Install netcat
#RUN apt-get update && apt-get install -y netcat
#
## Create working directory
#WORKDIR /app
#
## Copy JAR file
#COPY target/bookstore-0.0.1-SNAPSHOT.jar app.jar
#
## Expose port
#EXPOSE 8080
#
## The entrypoint is now controlled from docker-compose.yml
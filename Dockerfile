# Use an official OpenJDK runtime as a base image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at /app
COPY target/VPAsem-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "VPAsem-0.0.1-SNAPSHOT.jar"]
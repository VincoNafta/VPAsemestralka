FROM openjdk:17-jdk
WORKDIR /app

COPY target/VPAsem-0.0.1-SNAPSHOT.jar /app
LABEL authors="VincoNafta"

EXPOSE 8080
EXPOSE 8081
EXPOSE 6033

CMD ["java", "-jar","VPAsem-0.0.1-SNAPSHOT.jar"]


FROM openjdk:latest

WORKDIR /app

COPY target/gatekeeper_server_single-0.0.1-SNAPSHOT.jar /app/gatekeeper_server_single.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gatekeeper_server_single.jar"]


FROM openjdk:17-slim-buster

COPY build/libs/MsAuth-Amigo-0.0.1-SNAPSHOT.jar .

ENTRYPOINT java -jar MsAuth-Amigo-0.0.1-SNAPSHOT.jar
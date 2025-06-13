FROM openjdk:17-jdk-slim
WORKDIR /app
COPY ./target/biblioteca.salas.duoc-0.0.1-SNAPSHOT.jar app.jar
COPY wallet ./wallet
ENV TNS_ADMIN=./wallet
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]
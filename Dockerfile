FROM openjdk:18-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ./target/tipo-cambio.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar", "/app.jar" ]
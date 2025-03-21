FROM openjdk:17-jdk-alpine
EXPOSE 8085
ARG JAR_FILE=target/apigateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
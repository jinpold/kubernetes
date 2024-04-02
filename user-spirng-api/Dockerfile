FROM openjdk:17-alpine
LABEL description ="james"
VOLUME /tmp
ARG JAR_FILE=./build/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-in-image.jar"]

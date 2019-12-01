FROM openjdk:11
VOLUME /tmp
ARG JAR_FILES=./target/*.jar
COPY ${JAR_FILES} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
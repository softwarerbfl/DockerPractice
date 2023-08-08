FROM openjdk:17
LABEL maintainer="orange"
ARG JAR_FILE=build/libs/DockerPractice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} docker-springboot.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/docker-springboot.jar"]
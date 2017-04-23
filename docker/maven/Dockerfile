FROM maven:3-jdk-8-alpine

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

ADD . /usr/src/app

CMD ["mvn", "clean", "spring-boot:run"]
#CMD ["mvn", "package", "&&", "java", "-jar", "target/comment-microservice-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17

EXPOSE 8080

COPY target/examPortal-0.0.1-SNAPSHOT.jar exam.jar

ENTRYPOINT ["java", "-jar","/exam.jar"]
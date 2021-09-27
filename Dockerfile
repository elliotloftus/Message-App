FROM openjdk:11
ADD build/libs/messagee-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
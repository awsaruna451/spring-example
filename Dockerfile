FROM adoptopenjdk:11-jre-hotspot
ADD  target/spring-example-0.0.1-SNAPSHOT.jar spring-example.jar
ENTRYPOINT ["java", "-jar", "spring-example.jar"]



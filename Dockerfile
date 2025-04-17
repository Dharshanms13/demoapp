FROM openjdk:17
ADD target/demoapp-0.0.1-SNAPSHOT.jar demoapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "demoapp-0.0.1-SNAPSHOT.jar" ]
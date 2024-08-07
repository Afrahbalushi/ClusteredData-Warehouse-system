FROM openjdk:11
VOLUME /tmp
COPY target/fxdeals-1.0-SNAPSHOT.jar fxdeals.jar
ENTRYPOINT ["java", "-jar", "/fxdeals.jar"]
